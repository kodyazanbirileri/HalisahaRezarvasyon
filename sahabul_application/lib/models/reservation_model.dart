import 'package:sahabul_application/models/hours_model.dart';

class ReservationModel {
  late int reservationId;
  late String note;
  late int userId;
  late int pitchId;
  late String pitchName;
  late DateTime reservationDate;
  late HoursModel reservationHour;
  late bool status;

  ReservationModel({
    required this.pitchId,
    required this.note,
    required this.reservationHour,
    required this.reservationDate,
    required this.status,
    required this.reservationId,
    required this.userId,
    required this.pitchName,
  });

  factory ReservationModel.fromMap(Map reservationModelMap) {
    return ReservationModel(
        pitchId: reservationModelMap['pitchId'],
        note: reservationModelMap['note'],
        reservationHour:
            HoursModel.fromMap(reservationModelMap['reservationHour']),
        reservationDate: DateTime.parse(reservationModelMap['reservationDate']),
        status: reservationModelMap['status'],
        reservationId: reservationModelMap['id'],
        userId: reservationModelMap['userId'],
        pitchName: reservationModelMap['pitchName']);
  }
}
