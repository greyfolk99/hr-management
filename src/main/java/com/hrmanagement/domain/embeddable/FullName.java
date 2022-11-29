package com.hrmanagement.domain.embeddable;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Getter
public class FullName {
    @NotBlank
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;

    public String concat(){
        return middleName==null ?
                firstName+ " " + lastName :
                firstName+ " " + middleName + " " + lastName;
    }
}
