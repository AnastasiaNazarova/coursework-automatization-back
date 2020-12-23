package com.nazarova.back.controller;

import com.nazarova.back.model.Staff;
import com.nazarova.back.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @PostMapping("/add")
    public void addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
    }

    @GetMapping ("/delete")
    public void deleteStaff(@RequestParam Long id) {staffService.deleteStaff(id); }

    }
