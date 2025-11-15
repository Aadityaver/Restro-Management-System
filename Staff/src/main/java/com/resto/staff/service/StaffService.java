package com.resto.staff.service;

import com.resto.staff.DTO.StaffRequest;
import com.resto.staff.DTO.StaffResponse;
import com.resto.staff.enums.Role;
import com.resto.staff.enums.Status;

import java.util.List;

public interface StaffService {

    StaffResponse createStaff(StaffRequest request);
    StaffResponse updateStaff(Long staffId, StaffRequest request);
    void deleteStaff(Long staffId);
    StaffResponse getStaffById(Long staffId);
    List<StaffResponse> getAllStaff();
    StaffResponse updateRole(Long staffId, Role newRole);
    StaffResponse updateStatus(Long staffId, Status status);
    List<StaffResponse> getStaffByRestaurant(Long restaurant_id);
    StaffResponse assignUserAccount(Long staffId, Long userId);
}
