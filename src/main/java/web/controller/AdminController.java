package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.RoleOfUser;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("listUser", users);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(ModelAndView modelAndView) {
        User user = new User();
        Set<Role> listRols = userService.allRoles();
        modelAndView.addObject("roles", listRols);
        modelAndView.setViewName("addPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id, ModelAndView modelAndView) {
        User user = userService.getUserById(id);
//        List<RoleOfUser> listRols = Arrays.asList(RoleOfUser.values());
//        modelAndView.addObject("roles", listRols);

//        modelAndView.addObject("roles", roles);
//        modelAndView.addObject("role", role);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {

        userService.edit(user);
        modelAndView.setViewName("redirect:/admin");// redirect перенаправляет на адресс "/"
        return modelAndView;
    }
//    @GetMapping(value = "/admin/edit/{id}")
//    public ModelAndView editPage(@PathVariable("id") Long id, ModelAndView modelAndView) {
//        User user = userService.getUserById(id);
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("editPage");
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/edit")
//    public ModelAndView editUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
//        userService.edit(user);
//        modelAndView.setViewName("redirect:/");// redirect перенаправляет на адресс "/"
//        return modelAndView;
//    }



//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.add(user);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/delete/{id}")
//    @Transactional
//    public String deleteUser(@PathVariable("id") Long id) {
//        User user = userService.getUserById(id);
//        userService.delete(user);
//        return "redirect:/";
//    }
}
