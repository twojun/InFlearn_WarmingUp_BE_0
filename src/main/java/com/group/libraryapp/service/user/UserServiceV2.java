package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequestDto;
import com.group.libraryapp.dto.user.request.UserDeleteRequestDto;
import com.group.libraryapp.dto.user.request.UserUpdateRequestDto;
import com.group.libraryapp.dto.user.response.UserListResponseDto;
import com.group.libraryapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceV2 {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserCreateRequestDto request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserListResponseDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(UserListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequestDto request) {
        User findUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));

        findUser.updateName(request.getName());
    }

    @Transactional
    public void deleteUser(UserDeleteRequestDto request) {
        User findUser = userRepository.findByName(request.getName())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));

        userRepository.delete(findUser);
    }
}
