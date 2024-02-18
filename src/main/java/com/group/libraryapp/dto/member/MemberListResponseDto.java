package com.group.libraryapp.dto.member;

import com.group.libraryapp.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberListResponseDto {

    private String name;

    public MemberListResponseDto(Member member) {
        this.name = name;
    }
}
