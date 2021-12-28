
import 'package:flutter/material.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class OwnerForm extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return ReusableWidget(child:
    Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Text('Halı saha adı:',
        textAlign: TextAlign.left,),
        TextField(
          cursorColor: Colors.white,
          decoration: InputDecoration(
            hintText: 'enter here',

          ),
        )
      ],
    ));
  }
}
