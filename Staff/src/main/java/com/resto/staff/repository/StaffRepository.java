package com.resto.staff.repository;

import com.resto.staff.entity.Staff;
import com.resto.staff.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    List<Staff> findByRestaurantId(Long restaurantId);
    List<Staff> findByStatus(Status status);
}
