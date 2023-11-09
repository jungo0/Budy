package com.budy.registration.entity;

import com.budy.audit.Auditable;
import com.budy.route.entity.Route;
import javax.persistence.Column;
import javax.persistence.Entity;
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


}
