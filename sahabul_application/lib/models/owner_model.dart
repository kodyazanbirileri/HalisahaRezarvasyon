import 'package:sahabul_application/Models/user_model.dart';

class OwnerModel {
  late bool confirmed;
  late int id;
  late UserModel user;

  OwnerModel({
    required this.id,
    required this.confirmed,
    required this.user,
  });

  factory OwnerModel.fromMap(Map ownerModelMap) {
    return OwnerModel(
        id: ownerModelMap['id'],
        confirmed: ownerModelMap['confirmed'],
        user: UserModel.fromMap(ownerModelMap['user']));
  }
}
