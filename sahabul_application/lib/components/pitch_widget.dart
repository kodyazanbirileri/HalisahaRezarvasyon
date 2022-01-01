import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/pitch_model.dart';

class PitchWidget extends StatelessWidget {
  late Pitch pitch;
  late Function press;
  PitchWidget({Key? key, required this.pitch, required this.press})
      : assert(pitch != null),
        super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: GestureDetector(
        child: Padding(
          padding: EdgeInsets.all(10).copyWith(left: 0),
          child: ListTile(
            leading: Image.network(pitch.pictureUrl[0]),
            title: Text(pitch.pitchName),
            subtitle: Text(pitch.address),
            trailing: IconButton(
              icon: Icon(Icons.arrow_forward),
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
