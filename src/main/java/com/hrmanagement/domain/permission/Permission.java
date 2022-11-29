package com.hrmanagement.domain.permission;

import com.hrmanagement.domain.role.Role;
import com.hrmanagement.domain.common.TimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Permission extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "permission_id")
    private Integer id;
    private String name;
    private String module;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public static Permission has(Integer permissionId){
        return Permission.builder().id(permissionId).build();
    }

    public static Permission of(Integer roleId, PermissionInfoForm form){
        return Permission.builder()
                .role(Role.has(roleId))
                .name(form.getName())
                .module(form.getModule())
                .build();
    }
}
