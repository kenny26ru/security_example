package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.repository.UserRepository;
import web.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/logout")
    public String getOutPage() {
        return "login";
    }


    @GetMapping(value = "/user")
    public String getUserPage(Principal p, Model model) {
        model.addAttribute("user1", p.getName());
        return "user";
    }

}
