import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_dropdown.dart';
import 'package:sahabul_application/components/build_textfield.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class OwnerForm extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
        bar: AppBar(
          elevation: 0,
          backgroundColor: Color(0xff728840),
          leading: Container(),
        ),
        paddingHorizontal: 50,
        paddingVertical: 30,
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              BuildDropdown(),
              SizedBox(
                height: 20,
              ),
              BuildTextfield(
                text: 'Halısaha Adı',
                icon: Icon(
                  Icons.add_business,
                  color: Color(0xff728840),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              BuildTextfield(
                text: '5*********',
                icon: Icon(
                  Icons.add_call,
                  color: Color(0xff728840),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              BuildTextfield(
                text: 'Adres detay',
                icon: Icon(
                  Icons.add_location,
                  color: Color(0xff728840),
                ),
              ),
              TextButton(
                  onPressed: () {
                    showModalBottomSheet(
                        context: context,
                        builder: (BuildContext context) {
                          return ListView.builder(
                            padding: EdgeInsets.all(0),
                            scrollDirection: Axis.vertical,
                            shrinkWrap: true,
                            itemBuilder: (context, index) {
                              return ListTile(
                                title: Text('Provider'),
                                onTap: () {},
                                trailing: Checkbox(
                                  value: true,
                                  activeColor: Colors.lightBlueAccent,
                                  onChanged: (newValue) {},
                                ),
                              );
                            },
                            itemCount: 20,
                          );
                        });
                  },
                  child: Text('Halı saha özelliklerini seç.'))
            ],
          ),
        ));
  }
}
