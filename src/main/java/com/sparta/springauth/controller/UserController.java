package com.sparta.springauth.controller;

import com.sparta.springauth.dto.LoginRequestDto;
import com.sparta.springauth.dto.SignupRequestDto;
import com.sparta.springauth.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute SignupRequestDto requestDto) {
        userService.signup(requestDto);
        log.info("User 회원가입 , Id : {}, password : {}", requestDto.getUsername(), requestDto.getPassword());
        return "redirect:/api/user/login-page";
    }

  /*  @PostMapping("/user/login")
    public String login(@ModelAttribute LoginRequestDto requestDto, HttpServletResponse response) {
        try {
            userService.login(requestDto, response);
        } catch (Exception e) {
            log.info("Login error");
            return "redirect:/api/user/login-page?error";
        }

        return "redirect:/";
    }*/
}
