import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/reservation_model.dart';

class RezervationWidget extends StatelessWidget {
  late Rezervation rezervation;
  late Function press;
  RezervationWidget({Key? key, required this.rezervation, required this.press})
      : assert(rezervation != null),
        super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: GestureDetector(
        child: Padding(
          padding: EdgeInsets.all(10).copyWith(left: 0),
          child: ListTile(
            leading: Image.network(rezervation.pitch.pictureUrl[0]),
            title: Text(rezervation.pitch.pitchName),
            subtitle: Column(
              children: [
                Text(
                    '${rezervation.date.day}-${rezervation.date.month}-${rezervation.date.year}'),
                Text(
                    'Saat Aralığı: ${rezervation.startHour}- ${rezervation.endHour}'),
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
