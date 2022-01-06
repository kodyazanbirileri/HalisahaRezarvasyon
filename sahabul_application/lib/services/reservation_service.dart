import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/reservation_model.dart';
import 'package:sahabul_application/services/globals.dart';

class ReservationService {
  static Future<List<ReservationModel>> getReservations() async {
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

  static Future<List<dynamic>> getReservationHours(
      int pitchId, String reservationDate) async {
    Map data = {"date": reservationDate, "pitchId": pitchId};
    var body = json.encode(data);
    var url =
        Uri.parse(baseURL + "reservation/getReservationHoursByDateAndPitchId");
    http.Response response = await http.post(url, headers: headers, body: body);
    print(response.body);
    List<dynamic> reservationHours = jsonDecode(response.body);

    return reservationHours;
  }

  static Future<ReservationModel> makeReservation(
      int userId, int pitchId, int hourId, String reservationDate) async {
    Map data = {
      "reservationDate": reservationDate,
      "pitchId": pitchId,
      "userId": userId,
      "hourId": hourId,
      "note": "sonradan eklenecek."
    };
    var body = json.encode(data);
    var url = Uri.parse(baseURL + "reservation/add");
    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );
    print(response.body);
    Map reservationMap = jsonDecode(response.body);
    ReservationModel reservation = ReservationModel.fromMap(reservationMap);
    return reservation;
  }

  static Future<ReservationModel> deleteReservation(int reservationId) async {
    Map data = {
      "id": reservationId,
    };
    var body = json.encode(data);
    var url = Uri.parse(baseURL + "reservation/delete");
    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );
    print(response.body);
    Map reservationMap = jsonDecode(response.body);
    ReservationModel reservation = ReservationModel.fromMap(reservationMap);
    return reservation;
  }
}
