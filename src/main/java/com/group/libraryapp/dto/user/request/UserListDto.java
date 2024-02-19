package com.group.libraryapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserListDto {

    private long id;
    private String name;
    private Integer age;

    public UserListDto(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
