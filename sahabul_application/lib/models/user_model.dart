import 'package:sahabul_application/Models/reservation_model.dart';

class UserModel {
  late int id;
  late String email;
  late String firstName;
  late String lastName;
  late String phoneNumber;
  late List<ReservationModel> reservations;

  UserModel({
    required this.id,
    required this.lastName,
    required this.firstName,
    required this.email,
    required this.phoneNumber,
    required this.reservations,
  });

  factory UserModel.fromMap(Map userModelMap) {
    return UserModel(
        id: userModelMap['id'],
        lastName: userModelMap['lastName'],
        firstName: userModelMap['firstName'],
        email: userModelMap['email'],
        phoneNumber: userModelMap['phoneNumber'],
        reservations: userModelMap['reservations']
            .map((taskReservation) => ReservationModel.fromMap(taskReservation))
            .toList());
  }
}