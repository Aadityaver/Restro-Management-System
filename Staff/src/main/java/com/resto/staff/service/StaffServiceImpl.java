package com.resto.staff.service;

import com.resto.staff.DTO.StaffRequest;
import com.resto.staff.DTO.StaffResponse;
import com.resto.staff.entity.Staff;
import com.resto.staff.enums.Role;
import com.resto.staff.enums.Status;
import com.resto.staff.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public StaffResponse createStaff(StaffRequest request) {
        Staff staff = new Staff();
        staff.setName(request.getName());
        staff.setPhone(request.getPhone());
        staff.setStaffRole(request.getRole());
        staff.setStatus(Status.ACTIVE);
        staff.setRestaurantId(request.getRestaurant_id());
        staff.setUserId(request.getUser_id());

        Staff saved = staffRepository.save(staff);
        return mapToResponse(saved);
    }

    @Override
    public StaffResponse updateStaff(Long staffId, StaffRequest request) {
        Staff staff=staffRepository.findById(staffId).orElseThrow(()->new RuntimeException("Staff not found"));
        staff.setName(request.getName());
        staff.setPhone(request.getPhone());
        staff.setStaffRole(request.getRole());
        staff.setRestaurantId(request.getRestaurant_id());
        staff.setUserId(request.getUser_id());
        return mapToResponse(staffRepository.save(staff));
    }

    @Override
    public void deleteStaff(Long staffId) {
        if(!staffRepository.existsById(staffId)){
           throw  new RuntimeException("Staff not found  "+staffId);
        }
        staffRepository.deleteById(staffId);

    }

    @Override
    public StaffResponse getStaffById(Long staffId) {
        Staff staff=staffRepository.findById(staffId).orElseThrow(()->new RuntimeException("Staff not found"));
        return mapToResponse(staff);
    }

    @Override
    public List<StaffResponse> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public StaffResponse updateRole(Long staffId, Role newRole) {
        Staff staff=staffRepository.findById(staffId).orElseThrow(()->new RuntimeException("Staff not found"));
        staff.setStaffRole(newRole);
        return mapToResponse(staffRepository.save(staff));
    }

    @Override
    public StaffResponse updateStatus(Long staffId, Status status) {
        Staff staff=staffRepository.findById(staffId).orElseThrow(()->new RuntimeException("Staff not found"));
        staff.setStatus(status);
        return mapToResponse(staffRepository.save(staff));
    }

    @Override
    public List<StaffResponse> getStaffByRestaurant(Long restaurant_id) {
        return staffRepository.findById(restaurant_id).stream().map(this::mapToResponse).toList();
    }

    @Override
    public StaffResponse assignUserAccount(Long staffId, Long userId) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        staff.setUserId(userId);
        return mapToResponse(staffRepository.save(staff));
    }

    private StaffResponse mapToResponse(Staff staff) {
        StaffResponse res = new StaffResponse();
        res.setStaff_id(staff.getStaff_id());
        res.setName(staff.getName());
        res.setPhone(staff.getPhone());
        res.setStaffRole(staff.getStaffRole());
        res.setStatus(staff.getStatus());
        res.setRestaurant_id(staff.getRestaurantId());
        res.setUser_id(staff.getUserId());
        return res;
    }
}
