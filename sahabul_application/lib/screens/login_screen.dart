import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/build_forgot_pass_btn.dart';
import 'package:sahabul_application/components/build_password.dart';
import 'package:sahabul_application/components/build_sign_up_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/models/datas/user_data.dart';
import 'package:sahabul_application/models/user_model.dart';
import 'package:sahabul_application/services/user_service.dart';

class LoginScreen extends StatefulWidget {
  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  UserModel? user;
  final _formKey = GlobalKey<FormState>();
  final emailTextController = TextEditingController();
  final passwordTextController = TextEditingController();

  getUser(String email, String password) async {
    if (await UserService.checkUser(email, password)) {
      user = await UserService.getUserByEmail(email);
      Provider.of<UserData>(context, listen: false).user = user!;
      Navigator.pushNamed(context, 'layout');
    }
  }

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
                  getUser(
                      emailTextController.text, passwordTextController.text);
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
