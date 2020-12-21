package com.nazarova.back.repository;

import com.nazarova.back.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {

   @Modifying
   @Transactional
   @Query("DELETE FROM Staff l  WHERE l.id = ?1")
   void deleteStaff(long id);
}
