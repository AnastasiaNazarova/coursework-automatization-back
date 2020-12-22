package com.nazarova.back.repository;

import com.nazarova.back.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository  extends JpaRepository<Group, Long> {

    void deleteGroupByStaffId(Long staffId);
    void deleteGroupById(Long id);

    void updateGroupByStaffId(Long staffId);
    void updateGroupById(Long id);
}
