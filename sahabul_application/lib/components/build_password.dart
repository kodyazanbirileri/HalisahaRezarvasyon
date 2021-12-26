import 'package:flutter/material.dart';

class BuildPassword extends StatelessWidget {
  BuildPassword({
    required this.height,
    required this.hintText,
  });
  final double height;
  final String hintText;
  @override
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.centerLeft,
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(10),
        boxShadow: [
          BoxShadow(color: Colors.black26, blurRadius: 6, offset: Offset(0, 2)),
        ],
      ),
      height: height, //60
      child: TextField(
        textAlignVertical: TextAlignVertical.center,
        obscureText: true,
        style: TextStyle(
          color: Colors.black87,
        ),
        decoration: InputDecoration(
            border: InputBorder.none,
            prefixIcon: Icon(
              Icons.lock,
              color: Color(0xff728840),
            ),
            hintText: hintText, //Password
            hintStyle: TextStyle(
              color: Colors.black12,
            )),
      ),
    );
  }
}
