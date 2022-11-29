package com.hrmanagement.domain.training;

import com.hrmanagement.domain.common.TimeEntity;
import com.hrmanagement.domain.department.Department;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Training extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "training_id")
    private Integer id;
    private String type;
    private String detail;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public static Training of(Integer departmentId, TrainingInfoForm form){
        return Training.builder()
                .department(Department.has(departmentId))
                .type(form.getType())
                .detail(form.getDetail()).build();
    }
    public void update(TrainingInfoForm form) {
        this.type = form.getType();
        this.detail = form.getDetail();
    }
}
