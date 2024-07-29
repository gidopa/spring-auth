package com.sparta.springauth.controller;

import ch.qos.logback.classic.Logger;
import com.sparta.springauth.dto.ProductRequestDto;
import com.sparta.springauth.entity.User;
import com.sparta.springauth.entity.UserRoleEnum;
import com.sparta.springauth.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Secured(UserRoleEnum.Authority.ADMIN) // 관리자용
    @GetMapping("/products/secured")
    public String getProductsByAdmin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("userDetails.getUsername() = " + userDetails.getUsername());
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            System.out.println("authority.getAuthority() = " + authority.getAuthority());
        }
        return "redirect:/";
    }

    @PostMapping("/validation")
    @ResponseBody
    public ProductRequestDto testValid(@RequestBody @Valid ProductRequestDto requestDto) {
        return requestDto;
    }
}
