package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.generator.FirstNameGenerator;
import com.sda.springjavapoz4.service.generator.LastNameGenerator;
import com.sda.springjavapoz4.service.generator.PhoneNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class UsersService {

    private List<User> users;

    @Autowired
    private FirstNameGenerator firstNameGenerator;

    @Autowired
    private LastNameGenerator lastNameGenerator;

    @Autowired
    private PhoneNumberGenerator phoneNumberGenerator;

    public UsersService() {
        this.users = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());

        users.forEach(user -> System.out.println(user));
    }

    public User getUser(int id) {
        if (id <= users.size()) {
            users.get(id).setId(id);
        }
        return id >= users.size() ? null : users.get(id);
    }

    public List<User> getUserByFirstName(String firstName){

        return users.stream()
                .filter(user -> user.getFirstName().equals(firstName))
                .collect(Collectors.toList());

        /*List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().equals(firstName)) {
                userList.add(user);
            }
        }
        return userList;*/
    }

    public User getRandomUser(){
        Random random = new Random();
        int randomIndex = random.nextInt(users.size());
        return users.get(randomIndex);

    }

    public User getExampleUser() {
        User user = new User(1, firstNameGenerator.getRandomFirstName(), lastNameGenerator.getRandomLastName(), phoneNumberGenerator.getPhoneNumberName());
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }
}
