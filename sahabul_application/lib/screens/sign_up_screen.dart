import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/build_name_surname.dart';
import 'package:sahabul_application/components/build_password.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class SignUpScreen extends StatelessWidget {
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
              'Üye Ol',
              style: TextStyle(
                color: Colors.white,
                fontSize: 40,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(
              height: 100,
            ),
            BuildName(),
            SizedBox(
              height: 10,
            ),
            BuildEmail(
              height: 40,
              hintText: "Email",
            ),
            SizedBox(
              height: 10,
            ),
            BuildPassword(
              height: 40,
              hintText: "Password",
            ),
            SizedBox(
              height: 10,
            ),
            BuildPassword(
              height: 40,
              hintText: "Password Again",
            ),
            SizedBox(
              height: 30,
            ),
            BuildBtn(
              onPressed: () {
                Navigator.pushNamed(context, 'layout');
              },
              text: 'SIGN UP',
            ),
          ],
        ),
      ),
    );
  }
}
