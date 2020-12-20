package com.nazarova.back.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "member_rso")
public class MemberRSO {

    @Id
    @SequenceGenerator(name = "member_rso_seq", sequenceName = "member_rso_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_rso_seq")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "data_birth")
    private Date dataBirth;

    @ManyToOne()
    @JoinColumn(name = "group_id",  updatable = false, insertable = false)
    private Group group;

    @Column(name = "group_id")
    private Long  groupId;

    @Column(name = "post")
    private String post;

    @Column(name = "year_set")
    private Integer yearSet;

}
