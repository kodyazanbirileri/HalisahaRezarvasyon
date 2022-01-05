import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/models/pitch_model.dart';
import 'package:sahabul_application/screens/make_reservation.dart';

class PitchPage extends StatefulWidget {
  @override
  State<PitchPage> createState() => _PitchPageState();
}

class _PitchPageState extends State<PitchPage> {
  int selectedImage = 0;

  // GestureDetector buildSmallImages(int index, PitchArguments argument) {
  //   return GestureDetector(
  //     onTap: () {
  //       setState(() {
  //         selectedImage = index;
  //       });
  //     },
  //     child: Container(
  //       margin: EdgeInsets.only(right: 10),
  //       padding: EdgeInsets.all(4),
  //       height: 64,
  //       width: 64,
  //       decoration: BoxDecoration(
  //         color: Colors.white,
  //         borderRadius: BorderRadius.circular(20),
  //         border: Border.all(
  //             width: 5,
  //             color:
  //                 selectedImage == index ? Colors.green : Colors.transparent),
  //       ),
  //       child: Image.network(
  //         'https://media-cdn.t24.com.tr/media/library/2020/06/1592732200005-halisaha.jpg',
  //         fit: BoxFit.cover,
  //       ),
  //     ),
  //   );
  // }

  @override
  Widget build(BuildContext context) {
    final pitch = ModalRoute.of(context)!.settings.arguments as PitchModel;
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
            pitch.pitchName,
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
                "https://media-cdn.t24.com.tr/media/library/2020/06/1592732200005-halisaha.jpg",
                fit: BoxFit.cover,
              ),
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              // ...List.generate(pitch.pitchIndex.pictureUrl.length,
              //     (index) => buildSmallImages(index, argument)),
            ],
          ),
          Text(pitch.address),
          BuildBtn(
              paddingSynmetric: 25,
              text: 'Rezervasyon Yap',
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => MakeRezervation(),
                    settings: RouteSettings(
                      arguments: pitch.id,
                    ),
                  ),
                );
              })
        ],
      ),
    );
  }
}
