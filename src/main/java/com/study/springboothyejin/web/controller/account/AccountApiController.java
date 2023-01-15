package com.study.springboothyejin.web.controller.account;


import com.study.springboothyejin.service.UserService;
import com.study.springboothyejin.web.dto.CMRespDto;
import com.study.springboothyejin.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {
    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(String username) {
//        System.out.println(username);
        userService.duplicateUsername(username);
        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
