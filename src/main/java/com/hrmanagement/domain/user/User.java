package com.hrmanagement.domain.user;

import com.hrmanagement.domain.permission.Permission;
import com.hrmanagement.domain.role.Role;
import com.hrmanagement.domain.common.TimeEntity;
import com.hrmanagement.domain.embeddable.*;
import com.hrmanagement.domain.salary.Salary;
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
public class User extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;
    @Embedded
    private LoginInfo loginInfo;
    @Embedded
    private FullName fullName;
    @Embedded
    private ContactInfo contactInfo;
    @Embedded
    private Address address;
    private LocalDateTime deletedDate;
    @OneToMany(mappedBy = "user")
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Salary> salaries = new ArrayList<>();

    public void delete(){
        this.deletedDate = LocalDateTime.now();
    }

    public static User of(UserInfoForm form){
        return User.builder()
                .fullName(form.getFullName())
                .loginInfo(form.getLoginInfo())
                .contactInfo(form.getContactInfo())
                .address(form.getAddress())
                .build();
    }

    public static User has(Integer userId){
        return User.builder()
                .id(userId).build();
    }

    public void update(UserInfoForm form){
        this.fullName = form.getFullName();
        this.loginInfo = form.getLoginInfo();
        this.contactInfo = form.getContactInfo();
        this.address = form.getAddress();
    }
}
