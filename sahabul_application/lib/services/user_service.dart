import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:sahabul_application/models/user_model.dart';

import 'globals.dart';

class UserService {
  static Future<UserModel> getUserByEmail(String email) async {
    var body = json.encode(email);
    var url = Uri.parse(baseURL + 'user/getByEmail');

    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );

    Map userMap = jsonDecode(response.body);
    print(userMap);
    UserModel userModel = UserModel.fromMap(userMap);
    return userModel;
  }

  static Future<bool> checkUser(String email, String password) async {
    Map data = {
      "email": email,
      "password": password,
    };
    var body = json.encode(data);
    var url = Uri.parse(baseURL + 'user/checkUser');

    http.Response response = await http.post(
      url,
      headers: headers,
      body: body,
    );

    bool isUser = jsonDecode(response.body);
    return isUser;
  }
}
