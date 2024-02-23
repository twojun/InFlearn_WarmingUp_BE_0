package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequestDto;
import com.group.libraryapp.dto.user.request.UserDeleteRequestDto;
import com.group.libraryapp.dto.user.request.UserUpdateRequestDto;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public void saveUser(UserCreateRequestDto request) {
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<User> findAllUser() {
        return userJdbcRepository.findAllUser();
    }

    public void updateUser(UserUpdateRequestDto request) {
        if (userJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(UserDeleteRequestDto request) {
        if (userJdbcRepository.isUserNotExist(request.getName())) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        userJdbcRepository.deleteUserByUsername(request.getName());
    }
}
