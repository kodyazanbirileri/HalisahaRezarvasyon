import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/pitch_model.dart';
import 'package:sahabul_application/components/build_dropdown.dart';
import 'package:sahabul_application/components/pitch_widget.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/screens/pitch.dart';

class Searching extends StatefulWidget {
  @override
  State<Searching> createState() => _SearchingState();
}

class _SearchingState extends State<Searching> {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 20,
      paddingVertical: 0,
      child: Column(
        children: [
          BuildDropdown(),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: ListView.builder(
              itemCount: PitchModel.pitchs.length,
              itemBuilder: (context, index) {
                return PitchWidget(
                  pitch: PitchModel.pitchs[index],
                  press: () => Navigator.pushNamed(
                    context,
                    'pitch',
                    arguments: PitchArguments(
                      pitchIndex: PitchModel.pitchs[index],
                    ),
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
