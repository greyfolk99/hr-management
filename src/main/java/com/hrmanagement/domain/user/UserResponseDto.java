package com.hrmanagement.domain.user;

import com.hrmanagement.domain.embeddable.Address;
import com.hrmanagement.domain.embeddable.ContactInfo;
import com.hrmanagement.domain.embeddable.FullName;
import com.hrmanagement.domain.embeddable.LoginInfo;
import com.hrmanagement.domain.role.RoleResponseDto;

import java.util.List;

public class UserResponseDto {
    private Integer id;
    private LoginInfo loginInfo;
    private FullName fullName;
    private ContactInfo contactInfo;
    private Address address;
    private List<RoleResponseDto> roles;
}
