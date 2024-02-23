package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequestDto;
import com.group.libraryapp.dto.user.request.UserDeleteRequestDto;
import com.group.libraryapp.dto.user.request.UserUpdateRequestDto;
import com.group.libraryapp.dto.user.response.UserListResponseDto;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceV2 userService;

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
