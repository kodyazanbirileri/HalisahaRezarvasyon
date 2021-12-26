import 'package:flutter/material.dart';

class BuildForgotPassBtn extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: FlatButton(
        onPressed: () {
          Navigator.pushNamed(context, 'forgot_password_screen');
        },
        child: Text(
          'Parolamı unuttum',
          style: TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.bold,
            fontSize: 17,
          ),
        ),
      ),
    );
  }
}
