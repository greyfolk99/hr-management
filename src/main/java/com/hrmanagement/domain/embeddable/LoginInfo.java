package com.hrmanagement.domain.embeddable;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
public class LoginInfo {
    private String account;
    private String pwd;
}
