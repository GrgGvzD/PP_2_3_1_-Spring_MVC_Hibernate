package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public User getUserById(int id);
    public void deleteUserById(int id);
    public void updateUser(User user);
}
