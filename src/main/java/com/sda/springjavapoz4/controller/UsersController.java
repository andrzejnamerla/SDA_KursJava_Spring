package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* PathVariable - do wyciagania wartosci ze sciezki
 * RequestParam - do wyciagania wartosci z queryParameterow (/users?firstName=blabla)
 * ModelAttribute - do wyciagania danych wysylanych w formularzu (content-type: x-www-form-urlencoded)
 * RequestBody - do wyciagania danych wysylanych w body (np. content-type: application-json)
 * */

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public String saveUser(@ModelAttribute User user){
        usersService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping(consumes = "application/json")
    public String saveUserJson(@RequestBody User user){
        usersService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public ModelAndView getAllUsers(){
        ModelAndView modelAndView = new ModelAndView("userTab");
        modelAndView.addObject("users", usersService.getAllUsers());
        return modelAndView;
    }

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
