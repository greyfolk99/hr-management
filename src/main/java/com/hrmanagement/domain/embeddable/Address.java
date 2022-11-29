package com.hrmanagement.domain.embeddable;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String zipCode;
    private String address1;
    private String address2;
}
