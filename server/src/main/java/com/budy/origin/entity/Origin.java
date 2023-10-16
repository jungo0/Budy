package com.budy.origin.entity;

import com.budy.audit.Auditable;
import com.budy.route.entity.RouteOrigin;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Origin extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "origin_id")
    private Long originId;

    @Column(name = "origin_latitude")
    private Double originLatitude;

    @Column(name = "origin_longitude")
    private Double originLongitude;

    @OneToMany(mappedBy = "origin", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteOrigin> routeOriginList = new ArrayList<>();
}
