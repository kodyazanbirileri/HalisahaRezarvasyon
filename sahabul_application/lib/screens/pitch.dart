import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/halisaha.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class PitchPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final PitchArguments argument =
        ModalRoute.of(context)!.settings.arguments as PitchArguments;
    return ReusableWidget(
      child: Text(argument.pitchIndex.pitch_name),
      paddingHorizontal: 20,
      paddingvertical: 0,
    );
  }
}

class PitchArguments {
  late Pitch pitchIndex;

  PitchArguments({required this.pitchIndex});
}
