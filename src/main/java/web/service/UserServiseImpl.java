package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.models.User;

import java.util.List;
@Repository
public class UserServiseImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
//    UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
