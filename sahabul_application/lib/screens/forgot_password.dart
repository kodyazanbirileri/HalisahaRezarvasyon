import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class ForgotPassword extends StatefulWidget {
  @override
  State<ForgotPassword> createState() => _ForgotPasswordState();
}

class _ForgotPasswordState extends State<ForgotPassword> {
  final textEditingController = TextEditingController();

  @override
  void dispose() {
    // TODO: implement dispose
    textEditingController.dispose();
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
              textEditingController: textEditingController,
              height: 60,
              hintText: "Email",
            ),
            SizedBox(
              height: 20,
            ),
            BuildBtn(
              paddingSynmetric: 25,
              onPressed: () {
                print(
                    'Yeni Parolanız ${textEditingController.text} adresine gönderildi.');
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
