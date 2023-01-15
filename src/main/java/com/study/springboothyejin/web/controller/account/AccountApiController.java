package com.study.springboothyejin.web.controller.account;

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

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto,
                                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String,String> errorMap = new HashMap<String,String>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            errorMap.forEach((k, v) ->{
                System.out.println(k+" : "+v);
            });

            throw new CustomValidException(errorMap);
        }
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto,
                                      BindingResult bindingResult) {
//        System.out.println(userDto);
//        System.out.println(bindingResult.getFieldErrors());
        if(bindingResult.hasErrors()) {
            Map<String,String> errorMap = new HashMap<String,String>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            errorMap.forEach((k, v) ->{
                System.out.println(k+" : "+v);
            });
            throw new CustomValidException(errorMap);
        }
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
