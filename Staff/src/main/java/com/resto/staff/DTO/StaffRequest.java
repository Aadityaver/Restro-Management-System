package com.resto.staff.DTO;

import com.resto.staff.enums.Role;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StaffRequest {
    private String name;
    private String phone;
    private Role role;
    private Long restaurant_id;
    private Long user_id;
}
