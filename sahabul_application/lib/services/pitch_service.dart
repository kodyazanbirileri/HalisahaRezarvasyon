import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/pitch_model.dart';
import 'package:sahabul_application/services/globals.dart';

class PitchService {
  static Future<List<PitchModel>> getPitches() async {
    var url = Uri.parse(baseURL + "pitch/getAll");
    http.Response response = await http.get(
      url,
      headers: headers,
    );
    print(response.body);
    List responseList = jsonDecode(response.body);
    List<PitchModel> pitchModels = [];
    for (Map pitchMap in responseList) {
      PitchModel pitchModel = PitchModel.fromMap(pitchMap);
      pitchModels.add(pitchModel);
    }

    return pitchModels;
  }

  static Future<List<PitchModel>> getPitchesByCityId(int cityId) async {
    var body = json.encode(cityId);
    var url = Uri.parse(baseURL + "pitch/getByCityId");
    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );

    print(response.body);
    List responseList = jsonDecode(response.body);
    List<PitchModel> pitchModels = [];
    for (Map pitchMap in responseList) {
      PitchModel pitchModel = PitchModel.fromMap(pitchMap);
      pitchModels.add(pitchModel);
    }

    return pitchModels;
  }

  static Future<List<PitchModel>> getPitchesByDistrictId(int districtId) async {
    var body = json.encode(districtId);
    var url = Uri.parse(baseURL + "pitch/getByDistrictId");
    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );

    List responseList = jsonDecode(response.body);
    List<PitchModel> pitchModels = [];
    for (Map pitchMap in responseList) {
      PitchModel pitchModel = PitchModel.fromMap(pitchMap);
      pitchModels.add(pitchModel);
    }

    return pitchModels;
  }
}
