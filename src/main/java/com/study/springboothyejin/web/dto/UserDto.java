package com.study.springboothyejin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\d]{5,20}$",
            message = "사용자 이름은 영문, 숫자조합이어야하며 5자 이상 20자 이하로 작성하세요")
    private String username;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*])[a-zA-Z0-0~!@#$%^&*]{8,16}$",
    message = "비밀번호는 영문, 숫자, 특수문자를 포함하여 8~16자로 작성하세요")
    private String password;

    @Pattern(regexp = "^[가-힇]{2,5}$",message = "이름은 한글만 작성 가능하며 2자 이상 5자 이하만 입력가능합니다")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email
    private String email;
}