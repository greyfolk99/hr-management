package com.hrmanagement.domain.employee;

import com.hrmanagement.domain.common.TimeEntity;
import com.hrmanagement.domain.department.Department;
import com.hrmanagement.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Employee extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public static Employee has(Integer employeeId){
        return Employee.builder().id(employeeId).build();
    }
    public static Employee of(Integer userId, Integer depId){
        return Employee.builder()
                .user(User.has(userId))
                .department(Department.has(depId))
                .build();
    }
}
