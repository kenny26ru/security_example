package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void add(User user);

    void delete(User user);

    void edit(User user);

    User getUserById(Long id);

    Role getRoleByName(String name);

    List<User> allUsers();

    Set<Role> allRoles();
}
