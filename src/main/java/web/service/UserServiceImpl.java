package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.create(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.update(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        User response = userRepository.read(id);
        return response;
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = userRepository.getRoleByName(name);
        return role;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        List<User> users = userRepository.allUsers();
        return users;
    }

    @Override
    public Set<Role> allRoles() {
        Set<Role> allRoles = userRepository.allRoles();
        return allRoles;
    }
}
