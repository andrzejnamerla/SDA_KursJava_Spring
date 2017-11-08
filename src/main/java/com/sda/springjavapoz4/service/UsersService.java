package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.repository.UsersRepository;
import com.sda.springjavapoz4.service.generator.FirstNameGenerator;
import com.sda.springjavapoz4.service.generator.LastNameGenerator;
import com.sda.springjavapoz4.service.generator.PhoneNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UsersService {

    //private List<User> users;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private FirstNameGenerator firstNameGenerator;

    @Autowired
    private LastNameGenerator lastNameGenerator;

    @Autowired
    private PhoneNumberGenerator phoneNumberGenerator;

    public UsersService() {
        //this.users = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());

        usersRepository.findAll().forEach(user -> System.out.println(user));
    }

    public User getRandomUser(){
        return getExampleUser();

    }

    public User getExampleUser() {
        User user = new User(1, firstNameGenerator.getRandomFirstName(), lastNameGenerator.getRandomLastName(), phoneNumberGenerator.getPhoneNumberName());
        return user;
    }

    public User getUser(int id) {
        return usersRepository.findOne((long) id);
    }

    public List<User> getUserByFirstName(String firstName){

        return StreamSupport.stream(usersRepository.findAll().spliterator(),false)
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

    public List<User> getAllUsers() {
        return StreamSupport.stream(usersRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void addUser(User user){
        usersRepository.save(user);
    }
}
