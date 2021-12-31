import 'package:flutter/material.dart';
import 'package:sahabul_application/screens/forgot_password.dart';
import 'package:sahabul_application/screens/login_screen.dart';
import 'package:sahabul_application/screens/make_reservation.dart';
import 'package:sahabul_application/screens/owner_form.dart';
import 'package:sahabul_application/screens/pitch.dart';
import 'package:sahabul_application/screens/profile.dart';
import 'package:sahabul_application/screens/reservations.dart';
import 'package:sahabul_application/screens/searching.dart';
import 'package:sahabul_application/screens/sign_up_screen.dart';
import 'package:sahabul_application/screens/update_information.dart';

import 'layout.dart';

void main() {
  runApp(MyApp());
}

//TODO: AppBar ile geri sayfalar arası geçiş sağlanmalı.

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
        'update_information': (context) => UpdateInformation(),
        'pitch': (context) => PitchPage(),
        'owner_form': (context) => OwnerForm(),
        'make_reservation': (context) => MakeRezervation(),
      },
      debugShowCheckedModeBanner: false,
      title: 'Demo',
      home: LoginScreen(),
    );
  }
}
