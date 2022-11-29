package com.hrmanagement.domain.role;

import com.hrmanagement.domain.common.TimeEntity;
import com.hrmanagement.domain.permission.Permission;
import com.hrmanagement.domain.salary.Salary;
import com.hrmanagement.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Role extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "role")
    private List<Permission> permissions = new ArrayList<>();

    public static Role has(Integer id){
        return Role.builder().id(id).build();
    }
    public static Role of(Integer userId, String roleName){
        return Role.builder().user(User.has(userId)).name(roleName).build();
    }
}
