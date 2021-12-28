import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class ReusableWidget extends StatelessWidget {
  ReusableWidget(
      {required this.child,
      required this.paddingHorizontal,
      required this.paddingvertical});
  final Widget child;
  final double paddingHorizontal;
  final double paddingvertical;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
                    gradient: LinearGradient(
                      begin: Alignment.topCenter,
                      end: Alignment.bottomCenter,
                      colors: [
                        Color(0x66728840),
                        Color(0x99728840),
                        Color(0xcc728840),
                        Color(0xff728840),
                      ],
                    ),
                  ),
                  child: Padding(
                    padding: EdgeInsets.symmetric(
                      horizontal: paddingHorizontal,
                      vertical: paddingvertical,
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
