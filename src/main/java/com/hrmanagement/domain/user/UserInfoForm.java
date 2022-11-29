package com.hrmanagement.domain.user;

import com.hrmanagement.domain.embeddable.Address;
import com.hrmanagement.domain.embeddable.ContactInfo;
import com.hrmanagement.domain.embeddable.LoginInfo;
import lombok.Getter;

@Getter
public class UserInfoForm {
    private com.hrmanagement.domain.embeddable.FullName FullName;
    private LoginInfo loginInfo;
    private Address address;
    private ContactInfo contactInfo;
}
