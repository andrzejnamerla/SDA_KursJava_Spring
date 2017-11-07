package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{id}")
    public ModelAndView getUser(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("user");
        User user = usersService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(params = {"lastName"})
    public ModelAndView getUsersByLastName(@RequestParam("lastName") String lastName){
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("lastName", lastName);
        return modelAndView;

        /*System.out.println(lastName);
        return new ModelAndView("users");*/
    }

    @GetMapping(params = {"firstName"})
    public ModelAndView getUsersByFirstName(@RequestParam("firstName") String firstName) {

        ModelAndView modelAndView = new ModelAndView("userTab");
        List<User> userByFirstName = usersService.getUserByFirstName(firstName);
        modelAndView.addObject("users", userByFirstName);
        return modelAndView;
    }

    @GetMapping("/example")
    public ModelAndView getUsers() {
        System.out.println(usersService.getExampleUser());
        return new ModelAndView("users");
    }
}
