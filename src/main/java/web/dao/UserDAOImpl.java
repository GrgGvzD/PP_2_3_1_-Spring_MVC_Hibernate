package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(1,"Petr", "Petrov", "122@mail.ru"));
        users.add(new User(2,"Ivan", "Ivanov", "221@mail.ru"));
        users.add(new User(3,"Max", "maximov", "121@mail.ru"));
        users.add(new User(4,"Paul", "Pavlov", "212@mail.ru"));
        users.add(new User(5,"Victor", "Victorov", "222@mail.ru"));
    }
    @Override
    public List<User> getAllUsers () {
        return users;
    }
    @Override
    public User getUserById(int id) {
         return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

}
