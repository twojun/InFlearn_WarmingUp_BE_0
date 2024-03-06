package com.group.libraryapp.domain.user;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public User(String name, Integer age) {
        /* 회원의 이름은 공백일 수 없다 **/
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

    // 대출 : 도메인 내부에 핵심 비즈니스 추가(객체 간 협력이 가능하도록)
    public void loanBook(String bookName) {
        this.userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    // 반납
    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 책을 대상으로 대출 기록이 존재하지 않습니다."));

        targetHistory.doReturn();
    }
}
