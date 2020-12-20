package com.nazarova.back.repository;

import com.nazarova.back.model.MemberRSO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRSORepository extends JpaRepository<MemberRSO, Long> {


   // List<MemberRSO> getAllBy();

}
