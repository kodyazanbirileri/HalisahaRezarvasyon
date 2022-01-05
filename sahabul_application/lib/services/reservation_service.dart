import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/reservation_model.dart';
import 'package:sahabul_application/services/globals.dart';

class ReservationService {
  static Future<List<ReservationModel>> getHours() async {
    var url = Uri.parse(baseURL + "reservation/getAll");
    http.Response response = await http.get(
      url,
      headers: headers,
    );
    print(response.body);
    List responseList = jsonDecode(response.body);
    List<ReservationModel> reservationModels = [];
    for (Map reservationMap in responseList) {
      ReservationModel reservationModel =
          ReservationModel.fromMap(reservationMap);
      reservationModels.add(reservationModel);
    }

    return reservationModels;
  }
}
