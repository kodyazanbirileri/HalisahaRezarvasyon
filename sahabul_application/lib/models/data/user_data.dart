import 'package:flutter/material.dart';
import 'package:sahabul_application/models/user_model.dart';
import 'package:sahabul_application/services/user_service.dart';

class UserData extends ChangeNotifier {
  late UserModel user;

  void updateUserInformation(String email, String firstName, String lastName,
      String phoneNumber) async {
    user = await UserService.updateUser(
        user.id!, email, firstName, lastName, phoneNumber);
    notifyListeners();
  }
}
