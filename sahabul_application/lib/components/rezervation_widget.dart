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
            leading: Image.network(reservation.pitch.pictureUrl[0]),
            title: Text(reservation.pitchId),
            subtitle: Column(
              children: [
                Text(
                    '${reservation.date.day}-${reservation.date.month}-${reservation.date.year}'),
                Text(
                    'Saat Aralığı: ${reservation.startHour}- ${reservation.endHour}'),
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
