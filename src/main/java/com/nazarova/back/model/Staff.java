package com.nazarova.back.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


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

    public Staff(Long id, String nameStaff, Date dataCreatedStaff) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.dataCreatedStaff = dataCreatedStaff;
    }

//    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "id")
//    private Set<Group> group ;
  //  @Column(name = "group_id",  updatable = false, insertable = false)
  //  private Long groupId;

}
