package com.kyb.sahabul.entities.dto.updaterequest;

import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPhotoForPitchRequest;
import com.kyb.sahabul.entities.dto.createrequest.CreatePitchPropertyForPitchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePitchRequest {

    private int id;
    private String pitchName;
    private int pitchNumber;
    private int cityId;
    private int districtId;
    private String address;
    private List<CreatePitchPropertyForPitchRequest> pitchPropertyRequests;
    private List<CreatePitchPhotoForPitchRequest> pitchPhotoRequests;

}
