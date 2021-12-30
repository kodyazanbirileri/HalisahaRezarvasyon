import 'package:flutter/material.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class OwnerForm extends StatefulWidget {
  @override
  State<OwnerForm> createState() => _OwnerFormState();
}

class _OwnerFormState extends State<OwnerForm> {
  String? value;
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
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  DropdownButton<String>(
                    value: value,
                    hint: Text('İl seçin'),
                    onChanged: (String? newValue) {
                      setState(() {
                        this.value = newValue;
                      });
                    },
                    items: <String>['One', 'Two', 'Free', 'Four']
                        .map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                  ),
                  DropdownButton<String>(
                    value: value,
                    hint: Text('İlçe Seçin'),
                    onChanged: value == null
                        ? null
                        : (String? value) {
                            setState(() {
                              this.value = value;
                            });
                          },
                    items: <String>['One', 'Two', 'Free', 'Four']
                        .map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                  ),
                ],
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                child: Column(
                  children: [
                    Text(
                      'Halı saha adı:',
                      textAlign: TextAlign.left,
                    ),
                    TextField(
                      cursorColor: Colors.white,
                      decoration: InputDecoration(
                        hintText: 'enter here',
                      ),
                    ),
                  ],
                ),
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                child: Column(
                  children: [
                    Text(
                      'Halı saha numarası:',
                      textAlign: TextAlign.left,
                    ),
                    TextField(
                      cursorColor: Colors.white,
                      decoration: InputDecoration(
                        hintText: 'enter here',
                      ),
                    ),
                  ],
                ),
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                child: Column(
                  children: [
                    Text(
                      'Halı saha adresi:',
                      textAlign: TextAlign.left,
                    ),
                    TextField(
                      cursorColor: Colors.white,
                      decoration: InputDecoration(
                        hintText: 'enter here',
                      ),
                    ),
                  ],
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
