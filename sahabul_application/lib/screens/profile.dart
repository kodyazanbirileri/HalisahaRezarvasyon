import 'package:flutter/material.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class Profile extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
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
              //TODO: Son rezervasyon kartı gelecek. ? yoksa bilgisi yazacak.
              Card(
                child: Text('deneme'),
              ),
              BuildBtn(
                  text: 'Rezervasyonlarım',
                  onPressed: () {
                    Navigator.pushNamed(context, 'reservations');
                  })
            ],
          ),
        ),
        Container(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              GestureDetector(
                onTap: () {
                  Navigator.pushNamed(context, 'update_information');
                },
                child: Text('Bilgilerimi güncelle.'),
              ),
              GestureDetector(
                onTap: (){
                  Navigator.pushNamed(context, 'owner_form');
                },
                child: Text('Halı saha sahibi olmak istiyorum.'),
              )
            ],
          ),
        )
      ],
    ));
  }
}
