import 'package:flutter/material.dart';

class BuildBtn extends StatelessWidget {
  BuildBtn(
      {required this.text,
      required this.onPressed,
      required this.paddingSynmetric});

  final double paddingSynmetric;
  final Function onPressed;

  final String text;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.symmetric(vertical: paddingSynmetric),
      width: double.infinity,
      child: RaisedButton(
        elevation: 5,
        onPressed: () => onPressed(),
        padding: EdgeInsets.all(15),
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
        color: Colors.white,
        child: Text(
          text,
          style: TextStyle(
              color: Color(0xff728840),
              fontSize: 18,
              fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
