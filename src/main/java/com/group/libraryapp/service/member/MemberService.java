package com.group.libraryapp.service.member;

import com.group.libraryapp.domain.member.Member;
import com.group.libraryapp.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAllMembersList() {
        return memberRepository.findAll();
    }
}
