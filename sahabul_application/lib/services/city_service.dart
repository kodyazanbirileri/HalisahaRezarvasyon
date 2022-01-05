import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/city_model.dart';
import 'package:sahabul_application/services/globals.dart';

class CityService {
  static Future<List<CityModel>> getCities() async {
    var url = Uri.parse(baseURL + "cities/getAll");
    http.Response response = await http.get(
      url,
      headers: headers,
    );
    print(response.body);
    List responseList = jsonDecode(response.body);
    List<CityModel> cityModels = [];
    for (Map cityMap in responseList) {
      CityModel cityModel = CityModel.fromMap(cityMap);
      cityModels.add(cityModel);
    }

    return cityModels;
  }
}
