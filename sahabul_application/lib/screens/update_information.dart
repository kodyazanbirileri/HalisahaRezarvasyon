import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_email.dart';
import 'package:sahabul_application/components/build_textfield.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/models/data/user_data.dart';

class UpdateInformation extends StatefulWidget {
  @override
  State<UpdateInformation> createState() => _UpdateInformationState();
}

class _UpdateInformationState extends State<UpdateInformation> {
  final firstNameController = TextEditingController();
  final lastNameController = TextEditingController();
  final phoneNumberController = TextEditingController();
  final emailController = TextEditingController();

  @override
  void dispose() {
    firstNameController.dispose();
    emailController.dispose();
    lastNameController.dispose();
    phoneNumberController.dispose();
    super.dispose();
  }

  generateControllers() {
    firstNameController.text =
        Provider.of<UserData>(context, listen: false).user.firstName!;
    lastNameController.text =
        Provider.of<UserData>(context, listen: false).user.lastName!;
    emailController.text =
        Provider.of<UserData>(context, listen: false).user.email!;
    phoneNumberController.text =
        Provider.of<UserData>(context, listen: false).user.phoneNumber!;
  }

  @override
  initState() {
    generateControllers();
    super.initState();
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
              height: 40.0,
            ),
            Text(
              'Bilgilerimi Güncelle',
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
              textEditingController: firstNameController,
              icon: Icon(
                Icons.person,
                color: Color(0xff728840),
              ),
              text: 'İsim',
            ),
            SizedBox(
              height: 10,
            ),
            BuildTextfield(
              textEditingController: lastNameController,
              icon: Icon(
                Icons.person,
                color: Color(0xff728840),
              ),
              text: 'Soyisim',
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
            SizedBox(
              height: 10,
            ),
            BuildBtn(
              paddingSynmetric: 25,
              onPressed: () {
                Provider.of<UserData>(context, listen: false)
                    .updateUserInformation(
                        emailController.text,
                        firstNameController.text,
                        lastNameController.text,
                        phoneNumberController.text);

                Navigator.pushNamed(context, 'profile');
              },
              text: 'Güncelle',
            ),
          ],
        ),
      ),
    );
  }
}
