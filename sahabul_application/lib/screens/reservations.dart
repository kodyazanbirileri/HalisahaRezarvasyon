import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/rezervation_model.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/components/rezervation_widget.dart';

class Reservation extends StatefulWidget {
  @override
  State<Reservation> createState() => _ReservationState();
}

class _ReservationState extends State<Reservation> {
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
      child: ListView.builder(
        itemCount: RezervationModel.reservations.length,
        itemBuilder: (context, index) => RezervationWidget(
          rezervation: RezervationModel.reservations[index],
          press: () {
            setState(() {
              RezervationModel.reservations.removeAt(index);
            });
          },
        ),
      ),
    );
  }
}
