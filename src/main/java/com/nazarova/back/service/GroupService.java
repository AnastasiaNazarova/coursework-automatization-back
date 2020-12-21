package com.nazarova.back.service;

import com.nazarova.back.model.Group;
import com.nazarova.back.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public  GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

}
