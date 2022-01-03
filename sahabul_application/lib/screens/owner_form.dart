import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/build_dropdown.dart';
import 'package:sahabul_application/components/build_multiselect_widget.dart';
import 'package:sahabul_application/components/build_textfield.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class OwnerForm extends StatefulWidget {
  @override
  State<OwnerForm> createState() => _OwnerFormState();
}

class _OwnerFormState extends State<OwnerForm> {
  late String email;
  late String phone;
  late String password;
  late String nameSurname;
  final pitchNameController = TextEditingController();
  final phoneNumberController = TextEditingController();
  final addressController = TextEditingController();

  @override
  void dispose() {
    pitchNameController.dispose();
    phoneNumberController.dispose();
    addressController.dispose();
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
      paddingHorizontal: 50,
      paddingVertical: 10,
      child: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            BuildDropdown(),
            SizedBox(
              height: 15,
            ),
            BuildTextfield(
              textEditingController: pitchNameController,
              text: 'Halısaha Adı',
              icon: Icon(
                Icons.add_business,
                color: Color(0xff728840),
              ),
            ),
            SizedBox(
              height: 15,
            ),
            BuildTextfield(
              textEditingController: phoneNumberController,
              text: '5*********',
              icon: Icon(
                Icons.add_call,
                color: Color(0xff728840),
              ),
            ),
            SizedBox(
              height: 15,
            ),
            BuildTextfield(
              textEditingController: addressController,
              text: 'Adres detay',
              icon: Icon(
                Icons.add_location,
                color: Color(0xff728840),
              ),
            ),
            SizedBox(
              height: 15,
            ),
            MultiselectWidget(),
            BuildBtn(
                text: 'Halısaha Kaydı Oluştur',
                paddingSynmetric: 25,
                onPressed: () {})
          ],
        ),
      ),
    );
  }
}
