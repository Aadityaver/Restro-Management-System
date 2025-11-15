package com.resto.staff.DTO;

import com.resto.staff.enums.Role;
import com.resto.staff.enums.Status;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StaffResponse {
    private Long staff_id;
    private String name;
    private String phone;
    private Role staffRole;
    private Status status;
    private Long restaurant_id;
    private Long user_id;
}
