package com.nazarova.back.service;

import com.nazarova.back.model.MemberRSO;
import com.nazarova.back.repository.MemberRSORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberRSOService {

    private final MemberRSORepository memberRSORepository;

    @Autowired
    public  MemberRSOService(MemberRSORepository memberRSORepository) {
        this.memberRSORepository = memberRSORepository;
    }

    public List<MemberRSO> getAllMemberRSO() {
        return memberRSORepository.getAllBy();
    }

    public void addMemberRSO(MemberRSO memberRSO) {
        memberRSORepository.save(memberRSO);
    }
}