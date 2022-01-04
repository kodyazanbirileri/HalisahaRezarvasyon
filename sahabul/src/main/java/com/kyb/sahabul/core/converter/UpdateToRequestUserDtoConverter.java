package com.kyb.sahabul.core.converter;

import com.kyb.sahabul.entities.dto.createrequest.CreateUserRequest;
import com.kyb.sahabul.entities.dto.updaterequest.UpdateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateToRequestUserDtoConverter {


    public CreateUserRequest convert(UpdateUserRequest from)
    {
        return new CreateUserRequest(
                from.getFirstName(),
                from.getLastName(),
                from.getPassword(),
                from.getEmail(),
                from.getPhoneNumber()
        );
    }

}
