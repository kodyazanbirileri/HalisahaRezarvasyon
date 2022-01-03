package com.kyb.sahabul.entities.dto.createrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int phoneNumber;


}
