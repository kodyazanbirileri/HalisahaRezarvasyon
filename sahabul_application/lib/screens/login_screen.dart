import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/build_forgot_pass_btn.dart';
import 'package:sahabul_application/components/build_password.dart';
import 'package:sahabul_application/components/build_sign_up_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class LoginScreen extends StatefulWidget {
  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _formKey = GlobalKey<FormState>();
  final emailTextController = TextEditingController();
  final passwordTextController = TextEditingController();

  @override
  void dispose() {
    // TODO: implement dispose
    emailTextController.dispose();
    passwordTextController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 40,
      paddingVertical: 0,
      child: SingleChildScrollView(
        child: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              SizedBox(
                height: 70.0,
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
                textEditingController: emailTextController,
                height: 60,
                hintText: "Email",
              ),
              SizedBox(
                height: 20,
              ),
              BuildPassword(
                textEditingController: passwordTextController,
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
                paddingSynmetric: 25,
                onPressed: () {
                  print(
                      'Kullanıcı Adı: ${emailTextController.text} - Şifre: ${passwordTextController.text}');
                  Navigator.pushNamed(context, 'layout');
                },
                text: 'Giriş Yap',
              ),
              BuildSignUpBtn(),
            ],
          ),
        ),
      ),
    );
  }
}
