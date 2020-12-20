package com.nazarova.back.repository;


import com.nazarova.back.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository  extends JpaRepository<Group, Long> {
    List<Group> getAllBy();
}
