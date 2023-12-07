//
//package com.budy.tag.entity;
//
//import com.budy.audit.Auditable;
//import com.budy.route.entity.RouteTag;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//public class Tag extends Auditable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "tag_id")
//    private Long tagId;
//
//    @Column(name = "tag_name", nullable = false)
//    private String tagName;
//
//    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    private List<RouteTag> routeTagList = new ArrayList<>();
//}
//
