package web.repository;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {
//    private final Map<String, User> userMap = Collections.singletonMap("test",
//            new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER"))));

    @PersistenceContext
    private EntityManager em;

    @Override
    public User create(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User read(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User update(User user) {
        user = em.merge(user);
        return user;
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public List<User> allUsers() {
        List<User> users = em.createQuery("select u from User u").getResultList();
        return users;
    }

    @Override
    public User getUserByName(String userName) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.name = :userName", User.class);
        return query.setParameter("userName", userName).getSingleResult();
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = em.find(Role.class, name);
        return role;
    }

    @Override
    public Set<Role> allRoles() {
        Set<Role> allRoles = (Set<Role>) em.createQuery("select r from Role r").getResultList();
        return allRoles;
    }
}
