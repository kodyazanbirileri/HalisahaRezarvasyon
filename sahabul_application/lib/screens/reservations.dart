import 'package:flutter/material.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class Reservation extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      paddingHorizontal: 40,
      paddingvertical: 0,
      child: Center(
        child: Text('REZERVASYON SAYFASI'),
      ),
    );
  }
}
