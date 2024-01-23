package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
}
