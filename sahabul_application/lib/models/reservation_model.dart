import 'package:sahabul_application/Models/hours_model.dart';

class ReservationModel {
  late int id;
  late String note;
  late int userId;
  late int pitchId;
  late DateTime reservationDate;
  late HoursModel reservationHour;
  late bool status;

  ReservationModel({
    required this.pitchId,
    required this.note,
    required this.reservationHour,
    required this.reservationDate,
    required this.status,
    required this.id,
    required this.userId,
  });

  factory ReservationModel.fromMap(Map reservationModelMap) {
    return ReservationModel(
        pitchId: reservationModelMap['pitchId'],
        note: reservationModelMap['note'],
        reservationHour:
            HoursModel.fromMap(reservationModelMap['reservationHour']),
        reservationDate: DateTime.parse(reservationModelMap['reservationDate']),
        status: reservationModelMap['status'],
        id: reservationModelMap['id'],
        userId: reservationModelMap['userId']);
  }
}
