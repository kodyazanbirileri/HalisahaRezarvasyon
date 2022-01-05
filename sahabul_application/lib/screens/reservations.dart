import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/reservation_model.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class Reservation extends StatefulWidget {
  @override
  State<Reservation> createState() => _ReservationState();
}

class _ReservationState extends State<Reservation> {
  @override
  Widget build(BuildContext context) {
    final reservations = ModalRoute.of(context)!.settings.arguments as List;
    return ReusableWidget(
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 40,
      paddingVertical: 0,
      child: ListView.builder(
        itemCount: reservations.length,
        itemBuilder: (context, index) => RezervationWidget(
          reservation: ReservationModel.reservations[index],
          press: () {
            setState(() {
              ReservationModel.reservations.removeAt(index);
            });
          },
        ),
      ),
    );
  }
}
