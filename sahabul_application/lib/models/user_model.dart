import 'package:sahabul_application/models/reservation_model.dart';

class UserModel {
  int? id;
  String? email;
  String? firstName;
  String? lastName;
  String? phoneNumber;
  late List<dynamic> reservations;

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
