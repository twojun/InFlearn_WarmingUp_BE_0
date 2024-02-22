package com.group.libraryapp.repository.user;

import com.group.libraryapp.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveUser(String name, int age) {
        String sql = "insert into user(name, age) values(?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    public List<User> findAllUser() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) ->  {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new User(id, name, age);
        });
    }

    public boolean isUserNotExist(long id) {
        String selectSql = "select * from user where id = ?";
        return jdbcTemplate.query(selectSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public boolean isUserNotExist(String name) {
        String selectSql = "select * from user where name = ?";
        return jdbcTemplate.query(selectSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void updateUserName(String name, long id) {
        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void deleteUserByUsername(String name) {
        String sql = "delete from user where name = ?";
        jdbcTemplate.update(sql, name);
    }
}
