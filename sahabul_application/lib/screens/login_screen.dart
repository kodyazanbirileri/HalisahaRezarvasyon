import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/build_forgot_pass_btn.dart';
import 'package:sahabul_application/components/build_password.dart';
import 'package:sahabul_application/components/build_sign_up_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class LoginScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      paddingHorizontal: 40,
      paddingvertical: 0,
      child: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            SizedBox(
              height: 100.0,
            ),
            Text(
              'Sahabul',
              style: TextStyle(
                color: Colors.white,
                fontSize: 40,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(
              height: 100,
            ),
            BuildEmail(
              height: 60,
              hintText: "Email",
            ),
            SizedBox(
              height: 20,
            ),
            BuildPassword(
              hintText: 'Parola',
              height: 60,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: <Widget>[
                BuildForgotPassBtn(),
              ],
            ),
            BuildBtn(
              onPressed: () {
                Navigator.pushNamed(context, 'layout');
              },
              text: 'Giriş Yap',
            ),
            BuildSignUpBtn(),
          ],
        ),
      ),
    );
  }
}
