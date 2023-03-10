package com.study.springboothyejin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsernameDto {

    @Pattern(regexp = "^[a-zA-Z\\d]{5,20}$",
            message = "사용자 이름은 영문, 숫자조합이어야하며 5자 이상 20자 이하로 작성하세요")
    private String username;
}
