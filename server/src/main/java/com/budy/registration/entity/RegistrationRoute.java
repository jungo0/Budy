package com.budy.registration.entity;

import com.budy.audit.Auditable;
import com.budy.registration.entity.Registration.RegistrationState;
import com.budy.route.entity.Route;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegistrationRoute extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_route_id")
    private Long registrationRouteId;

    @ManyToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "registration_route_age_range")
    @Enumerated(EnumType.STRING)
    private RegistrationRouteAgeRange registrationRouteAgeRange;

    @Column(name = "registration_route_seat_number")
    private String registrationRouteSeatNumber;

    @Column(name = "registration_route_state")
    @Enumerated(EnumType.STRING)
    private RegistrationRouteState registrationRouteState;

    public enum RegistrationRouteAgeRange {
        ADULT,
        YOUTH,
        CHILD
    }

    public enum RegistrationRouteState {

        CANCELLATION,
        SUSPENSION,
        FAILURE,
        COMPLETION
    }
}
