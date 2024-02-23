package com.group.libraryapp.domain.user;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
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

    public User(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    protected User() {}

    public void updateName(String name) {
        this.name = name;
    }
}
