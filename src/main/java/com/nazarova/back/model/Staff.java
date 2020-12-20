package com.nazarova.back.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    private Long id;

    @Column(name = "name_staff")
    private String nameStaff;

    @Column(name = "data_created_staff")
    private Date dataCreatedStaff;

}
