package com.study.springboothyejin.web.controller.account;

import com.study.springboothyejin.aop.annotation.ValidAspect;
import com.study.springboothyejin.service.UserService;
import com.study.springboothyejin.web.dto.CMRespDto;
import com.study.springboothyejin.web.dto.UserDto;
import com.study.springboothyejin.web.dto.UsernameDto;
import com.study.springboothyejin.web.exception.CustomValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {
    @Autowired
    private UserService userService;

    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto,
                                               BindingResult bindingResult) {
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ValidAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto,
                                      BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
