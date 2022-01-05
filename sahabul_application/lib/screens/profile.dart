import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sahabul_application/components/build_btn.dart';
import 'package:sahabul_application/components/reusable_widget.dart';
import 'package:sahabul_application/models/datas/user_data.dart';
import 'package:sahabul_application/screens/reservations.dart';

class Profile extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ReusableWidget(
      bar: AppBar(
        centerTitle: true,
        title: Text(
          'Hesabım',
          style: TextStyle(
            fontSize: 25,
          ),
        ),
        elevation: 0,
        backgroundColor: Color(0xff728840),
        leading: Container(),
      ),
      paddingHorizontal: 40,
      paddingVertical: 0,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Container(
            child: Column(
              children: [
                Icon(
                  Icons.account_circle_rounded,
                  size: 150,
                  color: Colors.white,
                ),
                SizedBox(
                  height: 10,
                ),
                Text(
                  '${Provider.of<UserData>(context, listen: false).user.firstName!} ${Provider.of<UserData>(context, listen: false).user.lastName!}',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 32,
                  ),
                ),
                SizedBox(
                  height: 10,
                ),
                Text(
                  Provider.of<UserData>(context, listen: false)
                      .user
                      .phoneNumber!,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                SizedBox(
                  height: 10,
                ),
                Text(
                  Provider.of<UserData>(context, listen: false).user.email!,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16,
                  ),
                ),
                SizedBox(
                  height: 30,
                ),
              ],
            ),
          ),
          Container(
            child: Column(
              children: [
                Text(
                  'Son Rezervasyonum',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 24,
                  ),
                ),
                // PitchWidget(
                //     pitch: Pitch(
                //         pitchName: PitchModel.pitchs[0].pitchName,
                //         address: PitchModel.pitchs[0].address,
                //         telNumber: PitchModel.pitchs[0].telNumber,
                //         pictureUrl: PitchModel.pitchs[0].pictureUrl),
                //     press: () {}),
                BuildBtn(
                  paddingSynmetric: 0,
                  text: 'Rezervasyonlarım',
                  onPressed: () => Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => Reservation(),
                      settings: RouteSettings(
                        arguments: Provider.of<UserData>(context, listen: false)
                            .user
                            .reservations,
                      ),
                    ),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              GestureDetector(
                onTap: () {
                  Navigator.pushNamed(context, 'update_information');
                },
                child: Container(
                  padding: EdgeInsets.symmetric(vertical: 5, horizontal: 5),
                  decoration: BoxDecoration(
                    border: Border.all(color: Colors.white, width: 3),
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Text(
                    'Bilgilerimi güncelle',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                    ),
                  ),
                ),
              ),
              GestureDetector(
                onTap: () {
                  Navigator.pushNamed(context, 'owner_form');
                },
                child: Container(
                  padding: EdgeInsets.symmetric(vertical: 5, horizontal: 5),
                  decoration: BoxDecoration(
                    border: Border.all(color: Colors.white, width: 3),
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Text(
                    'Halısaha Sahibiyim',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                    ),
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
