import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/district_model.dart';
import 'package:sahabul_application/services/globals.dart';

class DistrictService {
  static Future<List<DistrictModel>> getDistrictByCityId(int cityId) async {
    Map data = {"id": cityId};

    var body = json.encode(data);
    var url = Uri.parse(baseURL + 'districts/getByCityId');

    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );

    print(response.body);
    List responseList = jsonDecode(response.body);
    List<DistrictModel> districtModels = [];
    for (Map districtMap in responseList) {
      print(districtMap);
      DistrictModel districtModel = DistrictModel.fromMap(districtMap);
      districtModels.add(districtModel);
    }
    return districtModels;
  }
}
