import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class ReusableWidget extends StatelessWidget {
  ReusableWidget(
      {required this.child,
      required this.paddingHorizontal,
      required this.paddingVertical,
      required this.bar});

  final Widget child;
  final double paddingHorizontal;
  final double paddingVertical;
  final AppBar bar;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: bar,
      body: AnnotatedRegion<SystemUiOverlayStyle>(
        value: SystemUiOverlayStyle.light,
        child: SafeArea(
          child: GestureDetector(
            child: Stack(
              children: <Widget>[
                Container(
                  height: double.infinity,
                  width: double.infinity,
                  decoration: BoxDecoration(
                    color: Color(0xff728840),
                  ),
                  child: Padding(
                    padding: EdgeInsets.symmetric(
                      horizontal: paddingHorizontal,
                      vertical: paddingVertical,
                    ),
                    child: child,
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
