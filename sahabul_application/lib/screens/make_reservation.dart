import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/models/data/hours_data.dart';
import 'package:sahabul_application/models/data/user_data.dart';
import 'package:sahabul_application/models/hours_model.dart';
import 'package:sahabul_application/services/hours_service.dart';
import 'package:sahabul_application/services/reservation_service.dart';
import 'package:sahabul_application/services/user_service.dart';

class MakeRezervation extends StatefulWidget {
  @override
  State<MakeRezervation> createState() => _MakeRezervationState();
}

class _MakeRezervationState extends State<MakeRezervation> {
  DateTime? _dateTime;
  List<HoursModel>? hours;
  DateFormat formatter = DateFormat('yyyy-MM-dd');

  getHours() async {
    hours = await HoursService.getHours();
    Provider.of<HoursData>(context, listen: false).hours = hours!;
    setState(() {});
  }

  getReservationHoursData(String date, int pitchId) async {
    Provider.of<HoursData>(context, listen: false).reservationHourList =
        await ReservationService.getReservationHours(pitchId, date);
    setState(() {});
  }

  @override
  void initState() {
    super.initState();
    getHours();
    Provider.of<HoursData>(context, listen: false).hoursDebugger();
    Provider.of<HoursData>(context, listen: false).reservationHourList = [];
  }

  makeReservation(
    int pitchId,
    int userId,
    int hourId,
    String date,
  ) async {
    await ReservationService.makeReservation(userId, pitchId, hourId, date);
    Provider.of<UserData>(context, listen: false).user =
        await UserService.getUserById(userId);
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    final pitchId = ModalRoute.of(context)!.settings.arguments as int;
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
                    getReservationHoursData(formatter.format(date!), pitchId);
                    setState(() {
                      Provider.of<HoursData>(context, listen: false)
                          .hoursDebugger();
                      _dateTime = date;
                    });
                  });
                }),
          ),
          Expanded(
            child: GridView.builder(
              itemCount:
                  Provider.of<HoursData>(context, listen: false).hours.length,
              gridDelegate:
                  SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
              itemBuilder: (context, index) {
                return ReservationHours(
                    index: Provider.of<HoursData>(context, listen: false)
                        .hours[index]);
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
                getReservationHoursData(formatter.format(_dateTime!), pitchId);
                setState(() {
                  makeReservation(
                      pitchId,
                      Provider.of<UserData>(context, listen: false).user.id!,
                      Provider.of<HoursData>(context, listen: false)
                          .selectedHour,
                      formatter.format(_dateTime!));
                });
                Navigator.pushNamed(context, 'profile');
              }),
        ],
      ),
    );
  }
}

class ReservationHours extends StatefulWidget {
  Color _HourTextColor = Color(0xff728840);

  late HoursModel index;
  int checkPress = 0;

  ReservationHours({
    required this.index,
  });

  @override
  State<ReservationHours> createState() => _ReservationHoursState();
}

class _ReservationHoursState extends State<ReservationHours> {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: Provider.of<HoursData>(context, listen: false)
              .reservationHourList
              .contains(widget.index.id)
          ? () {}
          : () {
              setState(() {
                if (Provider.of<HoursData>(context, listen: false)
                            .selectedHour ==
                        0 &&
                    widget.checkPress == 0) {
                  widget.checkPress = 1;
                  Provider.of<HoursData>(context, listen: false).selectedHour =
                      widget.index.id;
                  print(widget.checkPress);
                } else if (Provider.of<HoursData>(context, listen: false)
                            .selectedHour ==
                        widget.index.id &&
                    widget.checkPress == 1) {
                  widget.checkPress = 0;
                  Provider.of<HoursData>(context, listen: false).selectedHour =
                      0;
                  print(widget.checkPress);
                }
              });
            },
      child: Container(
        margin: EdgeInsets.all(5),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(
            10,
          ),
          color: Provider.of<HoursData>(context, listen: false)
                  .reservationHourList
                  .contains(widget.index.id)
              ? Colors.black
              : (widget.checkPress == 1 ? Colors.grey : Colors.white),
        ),
        child: Center(
          child: Text(
            '${widget.index.endHour}:00-${widget.index.startHour}:00',
            style: TextStyle(
              color: widget._HourTextColor,
              fontSize: 16,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}
