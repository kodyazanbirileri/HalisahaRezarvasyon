import 'package:flutter/material.dart';
import 'package:frontend/screens/forgot_password.dart';
import 'package:frontend/screens/login_screen.dart';
import 'package:frontend/screens/sign_up_screen.dart';

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
      },
      debugShowCheckedModeBanner: false,
      title: 'Demo',
      home: LoginScreen(),
    );
  }
}