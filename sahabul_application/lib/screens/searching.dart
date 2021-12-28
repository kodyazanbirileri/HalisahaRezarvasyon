import 'package:flutter/material.dart';
import 'package:sahabul_application/components/reusable_widget.dart';

class Searching extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      paddingHorizontal: 20,
      paddingvertical: 0,
      child: ListView(
        children: [
          Card(
            color: Colors.green,
            clipBehavior: Clip.antiAlias,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(12),
            ),
            child: Column(
              children: <Widget>[
                Stack(
                  children: [
                    Ink.image(
                      image: NetworkImage(
                        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
                      ),
                      height: 100,
                      fit: BoxFit.cover,
                    ),
                  ],
                ),
                Padding(
                  padding: EdgeInsets.all(10.0).copyWith(top: 5),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Text(
                        'Halısaha 1',
                        style: TextStyle(
                          fontSize: 16,
                          color: Colors.black,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      Text(
                        'Gönül Sokak no:23 Ortahisar/Trabzon',
                        style: TextStyle(
                          fontSize: 12,
                          color: Colors.black,
                        ),
                      ),
                    ],
                  ),
                )
              ],
            ),
          ),
        ],
      ),
    );
  }
}
