package com.nazarova.back.repository;

import com.nazarova.back.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, Long> {
 void deleteStaffById (long id);
}
