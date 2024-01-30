package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
//    private List<User> users;
//
//    {
//        users = new ArrayList<>();
//        users.add(new User(1,"Petr", "Petrov", "122@mail.ru"));
//        users.add(new User(2,"Ivan", "Ivanov", "221@mail.ru"));
//        users.add(new User(3,"Max", "maximov", "121@mail.ru"));
//        users.add(new User(4,"Paul", "Pavlov", "212@mail.ru"));
//        users.add(new User(5,"Victor", "Victorov", "222@mail.ru"));
//    }
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers () {
//        return users;
        return entityManager.createQuery("select user from User user").getResultList();
    }
    @Override
    public User getUserById(int id) {
         return entityManager.find(User.class, id);
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class,id));
//        users.remove(users.get(id-1));
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User editUser = getUserById(user.getId());
//        editUser.setName(user.getName());
//        editUser.setLastName(user.getLastName());
//        editUser.setEmail(user.getEmail());
        if (editUser != null) {
            editUser.setName(user.getName());
            editUser.setLastName(user.getLastName());
            editUser.setEmail(user.getEmail());
        }

    }

    @Override
    @Transactional
    public void addUser(User user) {
        System.out.println("addUser "+ user);
        entityManager.persist(user);
        System.out.println("persist "+ user);
        entityManager.flush();
        System.out.println("flush "+ user);
//        user.setId(users.size());
//        users.add(user);
    }

}
