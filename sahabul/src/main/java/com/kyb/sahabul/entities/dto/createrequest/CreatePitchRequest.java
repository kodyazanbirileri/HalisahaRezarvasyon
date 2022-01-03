package com.kyb.sahabul.entities.dto.createrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePitchRequest {

    private String pitchName;
    private int pitchNumber;
    private int cityId;
    private int districtId;
    private String address;
    private String startHour;
    private String endHour;
    private List<CreatePitchPropertyForPitchRequest> pitchPropertyRequests;
    private List<CreatePitchPhotoForPitchRequest> pitchPhotoRequests;


}
