package com.budy.member.service;

import com.budy.auth.jwt.JwtTokenizer;
import com.budy.member.entity.Member;
import com.budy.member.entity.Member.MemberRole;
import com.budy.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenizer jwtTokenizer;

    @Override
    public Member createMember(Member member) {
        member.setMemberRole(MemberRole.MEMBER);
        Member createMember = memberRepository.save(member);
        return createMember;
    }
}
