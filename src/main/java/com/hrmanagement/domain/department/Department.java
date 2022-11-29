package com.hrmanagement.domain.department;


import com.hrmanagement.domain.common.TimeEntity;
import com.hrmanagement.domain.embeddable.Address;
import com.hrmanagement.domain.employee.Employee;
import com.hrmanagement.domain.training.Training;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Department extends TimeEntity {
    @Id @GeneratedValue
    @Column(name = "department_id")
    private Integer id;
    private String name;
    private String type;
    private LocalDateTime deletedDate;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "department")
    private List<Training> trainings = new ArrayList<>();
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public static Department has(Integer depId) {
        return Department.builder().id(depId).build();
    }

    public void update(DepartmentInfoForm form){
        this.name = form.getName();
        this.type = form.getType();
        this.address = form.getAddress();
    }

    public static Department of(DepartmentInfoForm form){
        return Department.builder()
                .name(form.getName())
                .address(form.getAddress())
                .type(form.getType())
                .build();
    }

    public void delete(){
        this.deletedDate = LocalDateTime.now();
    }
}
