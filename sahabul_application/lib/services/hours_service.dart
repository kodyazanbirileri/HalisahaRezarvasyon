import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/hours_model.dart';
import 'package:sahabul_application/services/globals.dart';

class HoursService {
  static Future<List<HoursModel>> getHours() async {
    var url = Uri.parse(baseURL + "hours/getAll");
    http.Response response = await http.get(
      url,
      headers: headers,
    );
    print(response.body);
    List responseList = jsonDecode(response.body);
    List<HoursModel> hours = [];
    for (Map hoursMap in responseList) {
      HoursModel hoursModel = HoursModel.fromMap(hoursMap);
      hours.add(hoursModel);
    }

    return hours;
  }
}
