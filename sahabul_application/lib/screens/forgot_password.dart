import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class ForgotPassword extends StatelessWidget {
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
              'Şifremi Sıfırla',
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
            BuildBtn(
              onPressed: () {
                Navigator.pushNamed(context, 'login_screen');
              },
              text: 'Sıfırla',
            ),
          ],
        ),
      ),
    );
  }
}
