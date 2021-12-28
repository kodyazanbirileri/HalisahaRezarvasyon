import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/halisaha.dart';
import 'package:sahabul_application/components/pitch_widget.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/screens/pitch.dart';

class Searching extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      paddingHorizontal: 20,
      paddingvertical: 0,
      child: ListView.builder(
        itemCount: PitchModel.Pitchs.length,
        itemBuilder: (context, index) {
          return PitchWidget(
            pitch: PitchModel.Pitchs[index],
            press: () => Navigator.pushNamed(
              context,
              'pitch',
              arguments: PitchArguments(
                pitchIndex: PitchModel.Pitchs[index],
              ),
            ),
          );
        },
      ),
    );
  }
}
