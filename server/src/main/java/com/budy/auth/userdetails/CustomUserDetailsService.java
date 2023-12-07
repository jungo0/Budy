package com.budy.auth.userdetails;

import com.budy.auth.utils.CustomAuthorityUtils;
import com.budy.member.entity.Member;
import com.budy.member.repository.MemberRepository;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final CustomAuthorityUtils customAuthorityUtils;

    public CustomUserDetailsService(MemberRepository memberRepository,
        CustomAuthorityUtils customAuthorityUtils) {
        this.memberRepository = memberRepository;
        this.customAuthorityUtils = customAuthorityUtils;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member findMember = memberRepository.findByMemberEmail(username);
        if(findMember == null) throw new RuntimeException("Member Not Found");

        return new MemberDetails(findMember);
    }

    private final class MemberDetails extends Member implements UserDetails{

        public MemberDetails(Member member){
            setMemberId(member.getMemberId());
            setMemberEmail(member.getMemberEmail());
            setMemberRole(member.getMemberRole());
            setMemberName(member.getMemberName());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return customAuthorityUtils.createAuthorities(this.getMemberRole());
        }

        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public String getUsername() {
            return null;
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }
    }
}
