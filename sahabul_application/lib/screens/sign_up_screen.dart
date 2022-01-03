import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/build_password.dart';
import 'package:sahabul_application/components/build_textfield.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class SignUpScreen extends StatefulWidget {
  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  late String email;
  late String phone;
  late String password;
  late String nameSurname;
  final nameSurnameController = TextEditingController();
  final phoneNumberController = TextEditingController();
  final emailController = TextEditingController();
  final passwordController = TextEditingController();

  @override
  void initState() {
    super.initState();
  }

  @override
  void dispose() {
    // TODO: implement dispose
    nameSurnameController.dispose();
    phoneNumberController.dispose();
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
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            SizedBox(
              height: 70.0,
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
              height: 60,
            ),
            BuildTextfield(
              textEditingController: nameSurnameController,
              icon: Icon(
                Icons.person,
                color: Color(0xff728840),
              ),
              text: 'İsim Soyisim',
            ),
            SizedBox(
              height: 10,
            ),
            BuildTextfield(
              textEditingController: phoneNumberController,
              icon: Icon(
                Icons.add_call,
                color: Color(0xff728840),
              ),
              text: '5*********',
            ),
            SizedBox(
              height: 10,
            ),
            BuildEmail(
              textEditingController: emailController,
              height: 40,
              hintText: "Email",
            ),
            SizedBox(
              height: 10,
            ),
            BuildPassword(
              textEditingController: passwordController,
              height: 40,
              hintText: "Password",
            ),
            SizedBox(
              height: 10,
            ),
            BuildBtn(
              paddingSynmetric: 25,
              onPressed: () {
                nameSurname = nameSurnameController.text;
                print(nameSurname);
                // Navigator.pushNamed(context, 'layout');
              },
              text: 'SIGN UP',
            ),
          ],
        ),
      ),
    );
  }
}
