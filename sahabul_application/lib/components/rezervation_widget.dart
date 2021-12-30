import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/rezervation_model.dart';

class RezervationWidget extends StatelessWidget {
  late Rezervation rezervation;
  late GestureTapCallback press;
  RezervationWidget({Key? key, required this.rezervation, required this.press})
      : assert(rezervation != null),
        super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: GestureDetector(
        onTap: press,
        child: Padding(
          padding: EdgeInsets.all(10).copyWith(left: 0),
          child: ListTile(
            leading: Image.network(rezervation.pitch.picture_url[0]),
            title: Text(rezervation.pitch.pitch_name),
            subtitle: Column(
              children: [
                Text(
                    '${rezervation.date.day}-${rezervation.date.month}-${rezervation.date.year}'),
                Text(
                    'Saat Aralığı: ${rezervation.startHour}- ${rezervation.endHour}'),
              ],
            ),
            trailing: Icon(Icons.close),
          ),
        ),
      ),
      margin: EdgeInsets.only(bottom: 20),
    );
  }
}
