import 'dart:convert';

import 'package:http/http.dart' as http;

import 'globals.dart';

class UserService {
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
