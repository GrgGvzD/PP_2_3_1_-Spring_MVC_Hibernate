package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        // получим всех людей из дао и передадим на отображение в вью
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("?id={id}")
//    @GetMapping("/{id}")
    //переделать на ReqestParam
//    public String getUser(@PathVariable("id") int id, Model model) {
    public String getUser(@RequestParam(value = "id", required = false) int id, Model model) {
        // получим одного человека из дао отправим на отображение
        model.addAttribute("user", userService.getUserById(id));
        return "/users/user";
    }
}
