import 'package:flutter/material.dart';

class BuildEmail extends StatelessWidget {
  BuildEmail({
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
      height: height,
      child: TextField(
        textAlignVertical: TextAlignVertical.center,
        keyboardType: TextInputType.emailAddress,
        style: TextStyle(
          color: Colors.black87,
        ),
        decoration: InputDecoration(
            border: InputBorder.none,
            prefixIcon: Icon(
              Icons.email,
              color: Color(0xff728840),
            ),
            hintText: hintText, //email
            hintStyle: TextStyle(
              color: Colors.black12,
            )),
      ),
    );
  }
}
