import 'package:flutter/material.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class UpdateInformation extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 40,
      paddingVertical: 0,
      child: Center(
        child: Text('BİLGİLERİMİ GÜNCELLE SAYFASI'),
      ),
    );
  }
}
