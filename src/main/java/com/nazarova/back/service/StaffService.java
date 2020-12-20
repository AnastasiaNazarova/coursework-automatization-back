package com.nazarova.back.service;


import com.nazarova.back.model.Staff;
import com.nazarova.back.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public  StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.getAllBy();
    }

    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }
}
