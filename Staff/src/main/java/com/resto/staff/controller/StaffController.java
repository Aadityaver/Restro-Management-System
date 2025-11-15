package com.resto.staff.controller;

import com.resto.staff.DTO.StaffRequest;
import com.resto.staff.DTO.StaffResponse;
import com.resto.staff.entity.Staff;
import com.resto.staff.enums.Role;
import com.resto.staff.enums.Status;
import com.resto.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public StaffResponse createStaff(@RequestBody StaffRequest staffRequest){
        return staffService.createStaff(staffRequest);
    }

    @PutMapping("/{id}")
    public StaffResponse updateStaff(@PathVariable long id,@RequestBody StaffRequest staffRequest){
        return staffService.updateStaff(id,staffRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }

    @GetMapping("/{id}")
    public StaffResponse getById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @GetMapping
    public List<StaffResponse> getAll() {
        return staffService.getAllStaff();
    }

    @PutMapping("/{id}/role")
    public StaffResponse updateRole(@PathVariable Long id, @RequestParam Role role) {
        return staffService.updateRole(id, role);
    }

    @PutMapping("/{id}/status")
    public StaffResponse updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return staffService.updateStatus(id, status);
    }

    @GetMapping("/restaurant/{restId}")
    public List<StaffResponse> getByRestaurant(@PathVariable Long restId) {
        return staffService.getStaffByRestaurant(restId);
    }

    @PutMapping("/{id}/assign-user")
    public StaffResponse assignUser(@PathVariable Long id, @RequestParam Long userId) {
        return staffService.assignUserAccount(id, userId);
    }

}
