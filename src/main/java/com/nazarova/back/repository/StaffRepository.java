package com.nazarova.back.repository;

import com.nazarova.back.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    List<Staff> getAllBy();
}
