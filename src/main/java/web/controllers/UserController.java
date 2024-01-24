package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
//@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        // получим всех людей из дао и передадим на отображение в вью
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/get_user")
//    @GetMapping("/{id}")
    //переделать на ReqestParam
//    public String getUser(@PathVariable("id") int id, Model model) {
    public String getUser(@RequestParam(value = "id", required = false) int id, Model model) {
        // получим одного человека из дао отправим на отображение
        model.addAttribute("user", userService.getUserById(id));
        return "/user";
    }
//    @GetMapping("/newUser")
//    public String createNewUser(Model model) {
//        model.getAttribute("user");
//        return "";
//    }
    @GetMapping("/new")
    public String getNewUserForm(@ModelAttribute("user") User user) {
        return "/new_user";
    }

    @PostMapping("/new")
    public String creatNewUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }


    @GetMapping("/edit")
    public ModelAndView editUserForm(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("/edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/del_user")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
