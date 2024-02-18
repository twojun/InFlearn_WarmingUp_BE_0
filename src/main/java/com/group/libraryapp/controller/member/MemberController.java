package com.group.libraryapp.controller.member;

import com.group.libraryapp.config.CustomMyAnnotation;
import com.group.libraryapp.domain.member.Member;
import com.group.libraryapp.dto.member.MemberListResponseDto;
import com.group.libraryapp.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@CustomMyAnnotation(name = "MemberController", value = "MemberController")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public List<MemberListResponseDto> getAllMemberList() {
        List<Member> allMemberList = memberService.findAllMembersList();

        return allMemberList.stream()
                .map(member -> new MemberListResponseDto(member))
                .collect(Collectors.toList());
    }
}
