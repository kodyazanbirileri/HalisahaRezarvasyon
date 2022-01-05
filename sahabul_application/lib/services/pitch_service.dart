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
}
