package com.sparta.springauth.controller;

import ch.qos.logback.classic.Logger;
import com.sparta.springauth.entity.User;
import com.sparta.springauth.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@Slf4j
public class ProductController {

    @GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails){
      /*  System.out.println("ProductController.getProducts : 인증완료");
        User user = (User) request.getAttribute("user");
        System.out.println("user.getUsername() = " + user.getUsername());*/

        // Authentication 의 Principle 에 있는 userDetail 을 가져옴
        User user = userDetails.getUser();
        log.info("user.getUsername() = {}", user.getUsername());
        log.info("user.getEmail() = {}", user.getEmail());

        return "redirect:/";
    }
}
