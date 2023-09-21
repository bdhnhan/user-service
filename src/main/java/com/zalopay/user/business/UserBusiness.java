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

    public ResultResponse<User> login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findFirstByPhoneNumber(request.getUsername());
        if (userOptional.isPresent()) {
            if (userOptional.get().getPassword().equals(request.getPassword())) {
                User user = new User();
                user.setId(userOptional.get().getId());
                user.setPhoneNumber(userOptional.get().getPhoneNumber());
                user.setUsername(userOptional.get().getUsername());
                return ResultResponse.<User>builder()
                        .status(200L)
                        .message("SUCCESSFULLY")
                        .result(user)
                        .build();
            } else {
                return ResultResponse.<User>builder()
                        .status(600L)
                        .message("PASSWORD IS WRONG")
                        .result(null)
                        .build();
            }
        } else {
            return ResultResponse.<User>builder()
                    .status(400L)
                    .message("User not found")
                    .result(null)
                    .build();
        }
    }
}
