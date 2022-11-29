package com.hrmanagement.domain.department;

import com.hrmanagement.domain.embeddable.Address;
import lombok.Getter;

@Getter
public class DepartmentInfoForm {
    private String name;
    private String type;
    private String location;
    private Address address;
}
