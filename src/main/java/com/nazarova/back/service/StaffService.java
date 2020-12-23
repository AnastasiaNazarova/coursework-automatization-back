package com.nazarova.back.service;


import com.nazarova.back.model.Staff;
import com.nazarova.back.repository.GroupRepository;
import com.nazarova.back.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository, GroupRepository groupRepository) {
        this.staffRepository = staffRepository;
        this.groupRepository = groupRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Transactional
    public void deleteStaff(Long id) {
        groupRepository.deleteGroupByStaffId(id);
        staffRepository.deleteStaffById(id);
    }
}
