package com.zalopay.user.repository;

import com.zalopay.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findFirstByPhoneNumber(String phoneNumber);
}
