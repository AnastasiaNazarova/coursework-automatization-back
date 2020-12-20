package com.nazarova.back.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "group")
public class Group {

    @Id
    @SequenceGenerator(name = "group_seq", sequenceName = "group_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    private Long id;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "data_created_group")
    private Date dataCreatedGroup;

    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @Column(name = "staff_id",  updatable = false, insertable = false)
    private Long staffId;



}
