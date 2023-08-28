package com.zalopay.user.business;

import com.zalopay.user.controller.request.LoginRequest;
import com.zalopay.user.controller.response.ResultResponse;
import com.zalopay.user.entity.User;
import com.zalopay.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserBusiness {
    private final UserRepository userRepository;

    public UserBusiness(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResultResponse<String> login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findFirstByPhoneNumber(request.getUsername());
        if (userOptional.isPresent()) {
            if (userOptional.get().getPassword().equals(request.getPassword())) {
                return ResultResponse.<String>builder()
                        .status(200L)
                        .result("SUCCESSFULLY")
                        .build();
            } else {
                return ResultResponse.<String>builder()
                        .status(600L)
                        .result("PASSWORD IS WRONG")
                        .build();
            }
        } else {
            return ResultResponse.<String>builder()
                    .status(400L)
                    .result("User not found!")
                    .build();
        }
    }
}
