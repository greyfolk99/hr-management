package com.hrmanagement.domain.role;

import com.hrmanagement.domain.permission.Permission;
import com.hrmanagement.domain.permission.PermissionResponseDto;
import com.hrmanagement.domain.user.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class RoleResponseDto {
    private Integer id;
    private String name;
    private User user;
}
