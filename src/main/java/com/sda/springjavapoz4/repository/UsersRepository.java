package com.sda.springjavapoz4.repository;

import com.sda.springjavapoz4.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {


}
