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
        title: Text(pitch.pitchName),
        centerTitle: true,
      ),
      paddingHorizontal: 20,
      paddingVertical: 0,
      child: Column(
        children: [
          SizedBox(
            height: 40,
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
          Padding(
            padding: EdgeInsets.symmetric(
              horizontal: 35,
              vertical: 0,
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                SizedBox(
                  height: 20,
                ),
                Text(
                  'Telefon Numarası: ${pitch.pitchNumber.toString()}',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Text(
                  'Adres: ${pitch.address} ${pitch.district}/${pitch.city}',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Text(
                  'Çalışma Saatleri: 12:00 - 03:00',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Text(
                  'Halısaha Özellikleri: Servis, Otopark, Duş, Soyunma Odası, Ekipman Kiralama, Kafetarya, Wifi ',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
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
                  },
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
