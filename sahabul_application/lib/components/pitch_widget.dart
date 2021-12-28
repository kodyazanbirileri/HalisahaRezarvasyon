import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/halisaha.dart';

class PitchWidget extends StatelessWidget {
  late Pitch pitch;
  late GestureTapCallback press;
  PitchWidget({Key? key, required this.pitch, required this.press})
      : assert(pitch != null),
        super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: GestureDetector(
        onTap: press,
        child: Padding(
          padding: EdgeInsets.all(10).copyWith(left: 0),
          child: ListTile(
            leading: Image.network(pitch.picture_url),
            title: Text(pitch.pitch_name),
            subtitle: Text(pitch.address),
            trailing: Icon(Icons.arrow_forward),
          ),
        ),
      ),
      margin: EdgeInsets.only(bottom: 20),
    );
  }
}
