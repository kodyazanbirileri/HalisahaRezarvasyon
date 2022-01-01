import 'package:flutter/material.dart';

class BuildTextfield extends StatelessWidget {
  BuildTextfield({required this.text, required this.icon});
  late Icon icon;
  late String text;
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
      height: 40,
      child: TextField(
        textAlignVertical: TextAlignVertical.center,
        keyboardType: TextInputType.emailAddress,
        style: TextStyle(
          color: Colors.black87,
        ),
        decoration: InputDecoration(
          border: InputBorder.none,
          prefixIcon: icon,
          hintText: text,
          hintStyle: TextStyle(
            color: Colors.black12,
          ),
        ),
      ),
    );
  }
}
