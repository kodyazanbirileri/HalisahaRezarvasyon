import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/halisaha.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class PitchPage extends StatefulWidget {
  @override
  State<PitchPage> createState() => _PitchPageState();
}

class _PitchPageState extends State<PitchPage> {
  @override
  Widget build(BuildContext context) {
    final PitchArguments argument =
        ModalRoute.of(context)!.settings.arguments as PitchArguments;
    return ReusableWidget(
      paddingHorizontal: 20,
      paddingvertical: 0,
      child: Column(
        children: [
          Text(argument.pitchIndex.pitch_name),
          SizedBox(
            width: 300,
            height: 200,
            child: AspectRatio(
              aspectRatio: 1,
              child: Image.network(
                argument.pitchIndex.picture_url[0],
                fit: BoxFit.cover,
              ),
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ...List.generate(argument.pitchIndex.picture_url.length,
                  (index) => buildSmallImages(index, argument)),
            ],
          ),
          Text(argument.pitchIndex.tel_number),
          Text(argument.pitchIndex.address),
        ],
      ),
    );
  }
}

Container buildSmallImages(int index, PitchArguments argument) {
  return Container(
    margin: EdgeInsets.only(right: 10),
    padding: EdgeInsets.all(8),
    height: 48,
    width: 48,
    decoration: BoxDecoration(
      color: Colors.transparent,
      borderRadius: BorderRadius.circular(10),
      border: Border.all(color: Colors.black),
    ),
    child: Image.network(
      argument.pitchIndex.picture_url[index],
      fit: BoxFit.cover,
    ),
  );
}

class PitchArguments {
  late Pitch pitchIndex;

  PitchArguments({required this.pitchIndex});
}

// Text(argument.pitchIndex.pitch_name)
