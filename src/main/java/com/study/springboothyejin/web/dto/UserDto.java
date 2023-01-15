package com.study.springboothyejin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;

    @NotBlank
    private String username;
    private String password;
    private String name;
    private String email;
}