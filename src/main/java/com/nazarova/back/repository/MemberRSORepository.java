package com.nazarova.back.repository;

import com.nazarova.back.model.MemberRSO;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRSORepository extends JpaRepository<MemberRSO, Long> {
    void deleteMemberRSOById(long id);
    void deleteMemberRSOByGroupId(Long groupId);

}
