package com.nazarova.back.controller;


import com.nazarova.back.model.MemberRSO;
import com.nazarova.back.service.MemberRSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member_rso")
public class MemberRSOController {


    private final MemberRSOService memberRSOService;

    @Autowired
    public MemberRSOController(MemberRSOService memberRSOService) {
        this.memberRSOService = memberRSOService;
    }

    @GetMapping
    public List<MemberRSO> getAllMemberRSO() {
        return memberRSOService.getAllMemberRSO();
    }

    @PostMapping("/add")
    public void addMemberRSO(@RequestBody MemberRSO memberRSO) {
        memberRSOService.addMemberRSO(memberRSO);
    }

    @GetMapping ("/delete")
    public void deleteMemberRSO(@RequestParam Long id) {memberRSOService.deleteMemberRSO(id); }

    @GetMapping ("/update")
    public void updateMemberRSO(@RequestParam Long id) {memberRSOService.updateMemberRSO(id); }
}
