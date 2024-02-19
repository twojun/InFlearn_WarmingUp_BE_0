package com.group.libraryapp.domain.user;

import lombok.Getter;

@Getter
public class User {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        /** 회원의 이름은 공백일 수 없다 */
        if (name == null  || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 회원 이름 name(%s)이 입력되었습니다.", name));
        }
        this.name = name;
        this.age = age;
    }
}
