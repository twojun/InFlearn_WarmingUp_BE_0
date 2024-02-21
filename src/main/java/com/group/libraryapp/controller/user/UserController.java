package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequestDto;
import com.group.libraryapp.dto.user.request.UserDeleteRequestDto;
import com.group.libraryapp.dto.user.request.UserUpdateRequestDto;
import com.group.libraryapp.dto.user.response.UserListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/user")
    public List<UserListResponseDto> getAllUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) ->  {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserListResponseDto(id, name, age);
        });
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequestDto request) {
        String sql = "insert into user(name, age) values(?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequestDto request) {
        String selectSql = "select * from user where id = ?";
        boolean isUserNotExist = jdbcTemplate.query(selectSql, (rs, rowNum) -> 0, request.getId()).isEmpty();

        if (isUserNotExist) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }

        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(UserDeleteRequestDto request) {
        String selectSql = "select * from user where name = ?";
        boolean isUserNotExist = jdbcTemplate.query(selectSql, (rs, rowNum) -> 0, request.getName()).isEmpty();

        if (isUserNotExist) {
            throw new IllegalStateException("존재하지 않는 회원은 삭제할 수 없습니다.");
        }

        String sql = "delete from user where name = ?";
        jdbcTemplate.update(sql, request.getName());
    }
}
