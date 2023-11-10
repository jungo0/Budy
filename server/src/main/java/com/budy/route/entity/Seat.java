package com.budy.route.entity;

import com.budy.audit.Auditable;
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
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id", nullable = false, unique = true)
    private Long SeatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "seat_member_id", nullable = false)
    private long seatMemberId;

    @Column(name = "seat_member_type")
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteSeat> routeSeatList = new ArrayList<>();

    public enum MemberType {
        ADULT,
        YOUTH,
        CHILD
    }
}
