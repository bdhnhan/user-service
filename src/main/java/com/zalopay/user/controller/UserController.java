package com.zalopay.user.controller;

import com.zalopay.user.business.UserBusiness;
import com.zalopay.user.controller.request.LoginRequest;
import com.zalopay.user.controller.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserBusiness userBusiness;

    public UserController(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @PostMapping("/login")
    public ResultResponse<String> login(@RequestBody LoginRequest request) {
        log.info("request :: {}", request);
        return userBusiness.login(request);
    }
}
