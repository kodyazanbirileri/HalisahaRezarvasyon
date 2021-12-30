import 'package:flutter/material.dart';
import 'package:sahabul_application/Models/pitch_model.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class PitchPage extends StatefulWidget {
  @override
  State<PitchPage> createState() => _PitchPageState();
}

class _PitchPageState extends State<PitchPage> {
  int selectedImage = 0;

  GestureDetector buildSmallImages(int index, PitchArguments argument) {
    return GestureDetector(
      onTap: () {
        setState(() {
          selectedImage = index;
        });
      },
      child: Container(
        margin: EdgeInsets.only(right: 10),
        padding: EdgeInsets.all(4),
        height: 64,
        width: 64,
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(20),
          border: Border.all(
              width: 5,
              color:
                  selectedImage == index ? Colors.green : Colors.transparent),
        ),
        child: Image.network(
          argument.pitchIndex.picture_url[index],
          fit: BoxFit.cover,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final PitchArguments argument =
        ModalRoute.of(context)!.settings.arguments as PitchArguments;
    return ReusableWidget(
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 20,
      paddingVertical: 0,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Text(
            argument.pitchIndex.pitch_name,
            style: TextStyle(
              color: Colors.white,
              fontSize: 24,
              fontWeight: FontWeight.bold,
            ),
          ),
          SizedBox(
            height: 10,
          ),
          SizedBox(
            width: 300,
            height: 200,
            child: AspectRatio(
              aspectRatio: 1,
              child: Image.network(
                argument.pitchIndex.picture_url[selectedImage],
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
          BuildBtn(text: 'Rezervasyon Yap', onPressed: () {})
        ],
      ),
    );
  }
}

class PitchArguments {
  late Pitch pitchIndex;

  PitchArguments({required this.pitchIndex});
}

// Text(argument.pitchIndex.pitch_name)
