package com.htisolutions.controllers;

import com.htisolutions.entities.User;
import com.htisolutions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersViewController {

    private UserService userService;

    @Autowired
    UsersViewController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String add(@ModelAttribute(value="user") User user) {
        String forename = user.getForename();
        String surname = user.getSurname();

        userService.addUser(forename, surname);
        return ("redirect:/users");
    }

    @RequestMapping()
    public ModelAndView index() {
        User user = new User();
        user.setForename("forename");
        user.setSurname("surname");
        Iterable<User> users = userService.getUsers();

        ModelAndView model = new ModelAndView("views/users");
        model.addObject("users", users);
        model.addObject("user", user);
        return model;
    }
}
