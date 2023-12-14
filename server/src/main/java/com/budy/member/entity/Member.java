package com.budy.member.entity;

import com.budy.audit.Auditable;
import com.budy.registration.entity.Registration;
import com.budy.route.entity.Route;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "member_email", nullable = false)
    private String memberEmail;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_phone_number", unique = true)
    private String memberPhoneNumber;
//
//    @Column(name = "member_image", nullable = false)
//    private String memberImage;

//    @Column(name = "member_auth_type")
//    @Enumerated(EnumType.STRING)
//    private AuthType memberAuthType;

    @Column(name = "member_role")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    private List<Route> routeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Reservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Registration> registrationList = new ArrayList<>();

    public enum AuthType {
        GOOGLE,
        KAKAO
    }

    public enum MemberRole {
        MEMBER,
        ADMIN
    }
}
