package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequestDto;
import com.group.libraryapp.dto.user.request.UserDeleteRequestDto;
import com.group.libraryapp.dto.user.request.UserUpdateRequestDto;
import com.group.libraryapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(UserCreateRequestDto request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    public void updateUser(UserUpdateRequestDto request) {
        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        userRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(UserDeleteRequestDto request) {
        if (userRepository.isUserNotExist(request.getName())) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        userRepository.deleteUserByUsername(request.getName());
    }
}
