import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class Profile extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      paddingHorizontal: 40,
      paddingvertical: 0,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Container(
            child: Column(
              children: [
                Icon(
                  Icons.account_circle_rounded,
                  size: 120,
                ),
                //TODO: Style'lar güncellenecek.
                Text('Sırat Semih Çöp'),
                Text('05061583811'),
                Text('siratsemih@gmail.com'),
              ],
            ),
          ),
          Container(
            child: Column(
              children: [
                Text('Son Rezervasyon'),
                //TODO: Son rezervasyon kartı gelecek. ? yoksa bilgisi yazacak.
                // PitchWidget(
                //     pitch: Pitch(
                //         pitch_name: 'Örnek Halısaha',
                //         address: 'Konaklar Mahallesi Gönül Sokak',
                //         tel_number: '05334434343',
                //         picture_url:
                //             'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg'),
                //     press: () {}),
                BuildBtn(
                    text: 'Rezervasyonlarım',
                    onPressed: () {
                      Navigator.pushNamed(context, 'reservations');
                    })
              ],
            ),
          ),
          GestureDetector(
            onTap: () {
              Navigator.pushNamed(context, 'update_information');
            },
            child: Text('Bilgilerimi güncelle.'),
          ),
          GestureDetector(
            onTap: () {
              Navigator.pushNamed(context, 'owner_form');
            },
            child: Text('Halı saha sahibi olmak istiyorum.'),
          )
        ],
      ),
    );
  }
}
