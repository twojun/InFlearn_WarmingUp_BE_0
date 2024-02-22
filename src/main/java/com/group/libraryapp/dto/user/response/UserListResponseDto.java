package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.User;
import lombok.Getter;

@Getter
public class UserListResponseDto {

    private long id;
    private String name;
    private Integer age;

    public UserListResponseDto(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
