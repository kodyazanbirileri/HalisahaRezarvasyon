import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/models/data/city_data.dart';
import 'package:sahabul_application/models/data/district_data.dart';
import 'package:sahabul_application/models/data/pitch_data.dart';

class BuildDropdown extends StatefulWidget {
  const BuildDropdown({Key? key}) : super(key: key);

  @override
  _BuildDropdownState createState() => _BuildDropdownState();
}

class _BuildDropdownState extends State<BuildDropdown> {
  String? city;
  String? district;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        Container(
          width: 300,
          padding: EdgeInsets.symmetric(horizontal: 10, vertical: 0),
          decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.circular(5),
          ),
          child: DropdownButtonHideUnderline(
            child: DropdownButton<String>(
              value: city,
              hint: Text('İl seçin'),
              onChanged: (String? newValue) {
                //CityModal
                setState(() {
                  this.city = newValue; //cityModal.cityName
                  Provider.of<DistrictData>(context, listen: false)
                      .getAllById(int.parse(newValue!));
                  Provider.of<PitchData>(context, listen: false)
                      .getAllByCityId(int.parse(newValue));
                });
              },
              items: Provider.of<CityData>(context, listen: false)
                  .cities
                  .map((cityModel) {
                return DropdownMenuItem<String>(
                  value: cityModel.id.toString(),
                  child: Text(cityModel.cityName),
                );
              }).toList(),
            ),
          ),
        ),
        // Container(
        //   width: 150,
        //   padding: EdgeInsets.symmetric(horizontal: 10, vertical: 0),
        //   decoration: BoxDecoration(
        //     color: Colors.white,
        //     borderRadius: BorderRadius.circular(5),
        //   ),
        //   child: DropdownButtonHideUnderline(
        //     child: DropdownButton<String>(
        //       value: district,
        //       hint: Text('İlçe Seçin'),
        //       onChanged: (String? value) {
        //         setState(() {
        //           this.district = value; //DistrictModal.districtName
        //           //Pitch'den district id'ye göre veri çekilecek.
        //         });
        //       },
        //       items: Provider.of<DistrictData>(context, listen: false)
        //           .districts
        //           .map<DropdownMenuItem<String>>((districtModel) {
        //         return DropdownMenuItem<String>(
        //           value: districtModel.id.toString(),
        //           child: Text(districtModel.districtName),
        //         );
        //       }).toList(),
        //     ),
        //   ),
        // ),
      ],
    );
  }
}
