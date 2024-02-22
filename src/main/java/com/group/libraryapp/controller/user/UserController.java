package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequestDto;
import com.group.libraryapp.dto.user.request.UserDeleteRequestDto;
import com.group.libraryapp.dto.user.request.UserUpdateRequestDto;
import com.group.libraryapp.dto.user.response.UserListResponseDto;
import com.group.libraryapp.service.Fruit.FruitService;
import com.group.libraryapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequestDto request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserListResponseDto> getAllUsers() {
        return userService.findAllUser().stream()
                .map(user -> new UserListResponseDto(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequestDto request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(UserDeleteRequestDto request) {
        userService.deleteUser(request);
    }
}
