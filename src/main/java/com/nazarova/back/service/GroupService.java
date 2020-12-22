package com.nazarova.back.service;

import com.nazarova.back.model.Group;
import com.nazarova.back.repository.GroupRepository;
import com.nazarova.back.repository.MemberRSORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final MemberRSORepository memberRSORepository ;

    @Autowired
    public  GroupService(GroupRepository groupRepository,MemberRSORepository memberRSORepository) {
        this.groupRepository = groupRepository;
        this.memberRSORepository = memberRSORepository;
    }

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Transactional
    public void deleteGroup(Long id) {
        memberRSORepository.deleteMemberRSOByGroupId(id);
        groupRepository.deleteGroupById(id);
    }

    @Transactional
    public void updateGroup(Long id) {
        memberRSORepository.updateMemberRSOByGroupId(id);
        groupRepository.updateGroupById(id);
    }
}
