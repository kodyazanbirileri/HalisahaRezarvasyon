import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class MakeRezervation extends StatefulWidget {
  @override
  State<MakeRezervation> createState() => _MakeRezervationState();
}

class _MakeRezervationState extends State<MakeRezervation> {
  late DateTime _dateTime;
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      paddingHorizontal: 0,
      paddingVertical: 20,
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      child: Column(
        children: <Widget>[
          Container(
            padding: EdgeInsets.symmetric(horizontal: 40, vertical: 0),
            child: BuildBtn(
                text: 'Tarih Seçiniz',
                onPressed: () {
                  showDatePicker(
                    context: context,
                    initialDate: _dateTime == null ? DateTime.now() : _dateTime,
                    firstDate: DateTime.now(),
                    lastDate: DateTime.now().add(Duration(days: 14)),
                  ).then((date) {
                    setState(() {
                      _dateTime = DateTime.now();
                    });
                  });
                }),
          ),
        ],
      ),
    );
  }
}
