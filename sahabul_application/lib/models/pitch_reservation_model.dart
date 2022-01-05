import 'hours_model.dart';

class PitchReservationModel {
  late String firstName;
  late int id;
  late String lastName;
  late String note;
  late DateTime reservationDate;
  late HoursModel reservationHour;
  late bool status;

  PitchReservationModel({
    required this.id,
    required this.firstName,
    required this.status,
    required this.lastName,
    required this.note,
    required this.reservationDate,
    required this.reservationHour,
  });

  factory PitchReservationModel.fromMap(Map pitchReservationMap) {
    return PitchReservationModel(
        id: pitchReservationMap['id'],
        firstName: pitchReservationMap['firstName'],
        status: pitchReservationMap['status'],
        lastName: pitchReservationMap['lastName'],
        note: pitchReservationMap['note'],
        reservationDate: DateTime.parse(pitchReservationMap['reservationDate']),
        reservationHour:
            HoursModel.fromMap(pitchReservationMap['reservationHour']));
  }
}
