package com.hrmanagement.domain.embeddable;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ContactInfo {
    private String mobile;
    private String email;
}
