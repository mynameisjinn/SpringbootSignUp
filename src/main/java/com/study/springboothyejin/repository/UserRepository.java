package com.study.springboothyejin.repository;


import com.study.springboothyejin.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
    public UserDto findUserByUsername(String username);
}
