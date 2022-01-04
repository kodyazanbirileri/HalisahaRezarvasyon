package com.kyb.sahabul.entities.dto.updaterequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int phoneNumber;

}
