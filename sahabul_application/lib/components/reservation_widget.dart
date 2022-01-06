import 'package:flutter/material.dart';
import 'package:sahabul_application/models/reservation_model.dart';

class RezervationWidget extends StatelessWidget {
  late ReservationModel reservation;
  late Function press;
  RezervationWidget({Key? key, required this.reservation, required this.press})
      : assert(reservation != null),
        super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: GestureDetector(
        child: Padding(
          padding: EdgeInsets.all(10).copyWith(left: 0),
          child: ListTile(
            leading: Image.network(
                'https://i2.milimaj.com/i/milliyet/75/0x0/603df3005542811804d80ccf.jpg'),
            title: Text(reservation.pitchName),
            subtitle: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                    ' ${reservation.reservationDate.day}-${reservation.reservationDate.month}-${reservation.reservationDate.year}'),
                Text(
                    'Saat Aralığı: ${reservation.reservationHour.endHour}-${reservation.reservationHour.startHour}'),
              ],
            ),
            trailing: IconButton(
              icon: Icon(Icons.close),
              onPressed: () {
                press();
              },
            ),
          ),
        ),
      ),
      margin: EdgeInsets.only(bottom: 20),
    );
  }
}
