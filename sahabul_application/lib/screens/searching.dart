import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/components/build_dropdown.dart';
import 'package:sahabul_application/components/pitch_widget.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/models/city_model.dart';
import 'package:sahabul_application/models/datas/city_data.dart';
import 'package:sahabul_application/models/datas/pitch_data.dart';
import 'package:sahabul_application/models/pitch_model.dart';
import 'package:sahabul_application/screens/pitch.dart';
import 'package:sahabul_application/services/city_service.dart';

class Searching extends StatefulWidget {
  @override
  State<Searching> createState() => _SearchingState();
}

class _SearchingState extends State<Searching> {
  List<PitchModel>? pitches;
  List<CityModel>? districts;
  List<CityModel>? cities;

  getAllData() async {
    cities = await CityService.getCities();
    Provider.of<CityData>(context, listen: false).cities = cities!;
    setState(() {});
  }

  @override
  void initState() {
    super.initState();
    getAllData();
  }

  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      bar: AppBar(
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 20,
      paddingVertical: 0,
      child: Column(
        children: [
          BuildDropdown(),
          SizedBox(
            height: 20,
          ),
          Expanded(
            child: Consumer<PitchData>(builder: (context, pitchData, child) {
              return ListView.builder(
                itemCount: Provider.of<PitchData>(context, listen: false)
                    .pitches
                    .length,
                itemBuilder: (context, index) {
                  return PitchWidget(
                    pitch: pitchData.pitches[index],
                    press: () => Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => PitchPage(),
                        settings: RouteSettings(
                          arguments: pitchData.pitches[index],
                        ),
                      ),
                    ),
                  );
                },
              );
            }),
          ),
        ],
      ),
    );
  }
}
