package web.repository;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;


public interface UserRepository {
    User create(User user);

    User read(Long id);

    User update(User user);

    void delete(User user);

    List<User> allUsers();

    User getUserByName(String userName);

    Role getRoleByName(String name);

    Set<Role> allRoles();
}
