package com.budy.member.repository;


import com.budy.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberEmail(String memberEmail);
    Member findByMemberId(long memberId);
}
