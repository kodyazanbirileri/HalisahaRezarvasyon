import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/layout.dart';
import 'package:sahabul_application/models/datas/city_data.dart';
import 'package:sahabul_application/models/datas/district_data.dart';
import 'package:sahabul_application/models/datas/hours_data.dart';
import 'package:sahabul_application/models/datas/pitch_data.dart';
import 'package:sahabul_application/models/datas/user_data.dart';
import 'package:sahabul_application/screens/forgot_password.dart';
import 'package:sahabul_application/screens/login_screen.dart';
import 'package:sahabul_application/screens/make_reservation.dart';
import 'package:sahabul_application/screens/pitch.dart';
import 'package:sahabul_application/screens/profile.dart';
import 'package:sahabul_application/screens/searching.dart';
import 'package:sahabul_application/screens/sign_up_screen.dart';
import 'package:sahabul_application/screens/update_information.dart';

void main() {
  runApp(MyApp());
}

//TODO: AppBar ile geri sayfalar arası geçiş sağlanmalı.

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(
          create: (context) => UserData(),
        ),
        ChangeNotifierProvider(
          create: (context) => HoursData(),
        ),
        ChangeNotifierProvider(
          create: (context) => PitchData(),
        ),
        ChangeNotifierProvider(
          create: (context) => CityData(),
        ),
        ChangeNotifierProvider(
          create: (context) => DistrictData(),
        ),
      ],
      builder: (context, child) {
        return MaterialApp(
          initialRoute: 'login_screen',
          routes: {
            'login_screen': (context) => LoginScreen(),
            'sign_up_screen': (context) => SignUpScreen(),
            'forgot_password_screen': (context) => ForgotPassword(),
            'layout': (context) => Layout(),
            'searching': (context) => Searching(),
            // 'reservations': (context) => Reservation(),
            'profile': (context) => Profile(),
            'update_information': (context) => UpdateInformation(),
            'pitch': (context) => PitchPage(),
            // 'owner_form': (context) => OwnerForm(),
            'make_reservation': (context) => MakeRezervation(),
          },
          debugShowCheckedModeBanner: false,
          title: 'Demo',
          home: LoginScreen(),
        );
      },
    );
  }
}
