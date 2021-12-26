import 'package:flutter/material.dart';

class BuildRememberCb extends StatefulWidget {
  @override
  _BuildRememberCbState createState() => _BuildRememberCbState();
}

class _BuildRememberCbState extends State<BuildRememberCb> {
  bool isRememberMe = false;

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 20,
      child: Row(
        children: <Widget>[
          Theme(
            data: ThemeData(unselectedWidgetColor: Colors.white),
            child: Checkbox(
              value: isRememberMe,
              checkColor: Colors.green,
              activeColor: Colors.white,
              onChanged: (value) {
                setState(() {
                  isRememberMe = value!;
                });
              },
            ),
          ),
          Text(
            'Remember me',
            style: TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
            ),
          )
        ],
      ),
    );
  }
}
