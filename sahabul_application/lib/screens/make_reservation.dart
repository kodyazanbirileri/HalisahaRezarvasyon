import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/hours_model.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class MakeRezervation extends StatefulWidget {
  @override
  State<MakeRezervation> createState() => _MakeRezervationState();
}

class _MakeRezervationState extends State<MakeRezervation> {
  DateTime? _dateTime;
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
                text: _dateTime == null
                    ? 'Tarih giriniz'
                    : '${_dateTime!.day} / ${_dateTime!.month}',
                onPressed: () {
                  showDatePicker(
                    context: context,
                    initialDatePickerMode: DatePickerMode.day,
                    initialDate: DateTime.now(),
                    firstDate: DateTime.now(),
                    lastDate: DateTime.now().add(Duration(days: 14)),
                  ).then((date) {
                    setState(() {
                      _dateTime = date;
                    });
                  });
                }),
          ),
          Expanded(
            child: GridView.builder(
              itemCount: HoursModel.hours.length,
              gridDelegate:
                  SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
              itemBuilder: (context, index) {
                return ReservationHours(
                  index: index,
                );
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
                print(_dateTime);
                print('Rezervasyon yapıldı');
              }),
        ],
      ),
    );
  }
}

class ReservationHours extends StatefulWidget {
  bool _HoursSelected = false;
  Color _HourBackground = Colors.white;
  Color _HourTextColor = Color(0xff728840);

  late int index;

  ReservationHours({Key? key, required this.index});

  @override
  State<ReservationHours> createState() => _ReservationHoursState();
}

class _ReservationHoursState extends State<ReservationHours> {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        widget._HoursSelected = !widget._HoursSelected;
        setState(() {
          if (widget._HoursSelected) {
            widget._HourBackground = Colors.blueAccent;
            widget._HourTextColor = Colors.white;
          } else {
            widget._HourBackground = Colors.white;
            widget._HourTextColor = Color(0xff728840);
          }
        });
      },
      child: Container(
        margin: EdgeInsets.all(5),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(
            10,
          ),
          color: widget._HourBackground,
        ),
        child: Center(
          child: Text(
            HoursModel.hours[widget.index].hour,
            style: TextStyle(
              color: widget._HourTextColor,
              fontSize: 18,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}
