import 'package:flutter/material.dart';
import 'package:sahabul_application/screens/forgot_password.dart';
import 'package:sahabul_application/screens/login_screen.dart';
import 'package:sahabul_application/screens/profile.dart';
import 'package:sahabul_application/screens/reservations.dart';
import 'package:sahabul_application/screens/searching.dart';
import 'package:sahabul_application/screens/sign_up_screen.dart';

import 'layout.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: 'login_screen',
      routes: {
        'login_screen': (context) => LoginScreen(),
        'sign_up_screen': (context) => SignUpScreen(),
        'forgot_password_screen': (context) => ForgotPassword(),
        'layout': (context) => Layout(),
        'searching': (context) => Searching(),
        'reservations': (context) => Reservation(),
        'profile': (context) => Profile(),
      },
      debugShowCheckedModeBanner: false,
      title: 'Demo',
      home: LoginScreen(),
    );
  }
}
