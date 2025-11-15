package com.resto.staff.entity;

import com.resto.staff.enums.Role;
import com.resto.staff.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staff_id;
    private String name;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role staffRole;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "restaurant_id")
    private Long restaurantId;
    @Column(name = "user_id")
    private Long userId;


}
