import 'package:flutter/material.dart';
import 'package:sahabul_application/models/pitch_model.dart';

class PitchWidget extends StatelessWidget {
  late PitchModel pitch;
  late Function press;
  PitchWidget({Key? key, required this.pitch, required this.press});

  @override
  Widget build(BuildContext context) {
    return Card(
      child: GestureDetector(
        child: Padding(
          padding: EdgeInsets.all(10).copyWith(left: 0),
          child: ListTile(
            leading: Image.network(
                "https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg"),
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
