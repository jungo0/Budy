package com.budy.registration.entity;

import com.budy.audit.Auditable;
import com.budy.member.entity.Member;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Registration extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "registration_price")
    private Integer registrationPrice;

    @Column(name = "registration_state")
    @Enumerated(EnumType.STRING)
    private RegistrationState registrationState;

    @OneToMany(mappedBy = "registration", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RegistrationRoute> registrationRouteList = new ArrayList<>();

    public enum RegistrationState {

        CANCELLATION,
        SUSPENSION,
        FAILURE,
        COMPLETION
    }
}