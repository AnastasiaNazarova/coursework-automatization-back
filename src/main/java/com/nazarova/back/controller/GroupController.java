package com.nazarova.back.controller;

import com.nazarova.back.model.Group;
import com.nazarova.back.model.Staff;
import com.nazarova.back.service.GroupService;
import com.nazarova.back.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getAllGroup() {
        return groupService.getAllGroup();
    }

    @PostMapping("/add")
    public void addGroup(@RequestBody Group group) {
        groupService.addGroup(group);
    }

    @GetMapping("/delete")
    public void deleteGroup (@RequestParam Long id) {groupService.deleteGroup(id); }


}
