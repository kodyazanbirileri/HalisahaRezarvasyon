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
      paddingHorizontal: 40,
      paddingVertical: 0,
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
                paddingSynmetric: 25,
                text: 'Tarih Seçiniz',
                onPressed: () {
                  showDatePicker(
                    context: context,
                    initialDate: DateTime.now(),
                    firstDate: DateTime.now(),
                    lastDate: DateTime.now().add(Duration(days: 14)),
                  ).then((date) {
                    setState(() {
                      _dateTime = DateTime.now();
                    });
                  });
                }),
          ),
          Expanded(
            child: GridView.builder(
              itemCount: 15,
              gridDelegate:
                  SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
              itemBuilder: (context, index) {
                return reservation_hours();
              },
            ),
          ),
          SizedBox(
            height: 15,
          ),
          BuildBtn(
              paddingSynmetric: 25,
              text: 'Rezervasyon Yap',
              onPressed: () {
                print('Rezervasyon yapıldı');
              }),
        ],
      ),
    );
  }
}

class reservation_hours extends StatefulWidget {
  @override
  State<reservation_hours> createState() => _reservation_hoursState();
}

class _reservation_hoursState extends State<reservation_hours> {
  bool _HoursSelected = false;
  Color _HourBackground = Colors.white;
  Color _HourTextColor = Color(0xff728840);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        _HoursSelected = !_HoursSelected;
        setState(() {
          if (_HoursSelected) {
            _HourBackground = Colors.blueAccent;
            _HourTextColor = Colors.white;
          } else {
            _HourBackground = Colors.white;
            _HourTextColor = Color(0xff728840);
          }
        });
      },
      child: Container(
        margin: EdgeInsets.all(5),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(
            10,
          ),
          color: _HourBackground,
        ),
        child: Center(
          child: Text(
            '12-13',
            style: TextStyle(
              color: _HourTextColor,
              fontSize: 18,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}
