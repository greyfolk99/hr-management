package com.hrmanagement.domain.salary;

import com.hrmanagement.domain.common.TimeEntity;
import com.hrmanagement.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Salary extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "salary_id")
    private Integer id;
    private int amount;
    private String type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Salary has(Integer salaryId) {
        return Salary.builder().id(salaryId).build();
    }

    public static Salary of(Integer userId, SalaryInfoForm form) {
        return Salary.builder()
                .user(User.has(userId))
                .amount(form.getAmount())
                .type(form.getType())
                .build();
    }
}
