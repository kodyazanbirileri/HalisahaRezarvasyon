import 'package:flutter/material.dart';
import 'package:sahabul_application/models/hours_model.dart';

class HoursData extends ChangeNotifier {
  List<HoursModel> hours = [];
  List<dynamic> reservationHourList = [];
  int selectedHour = 0;

  void hoursDebugger() {
    selectedHour = 0;
    notifyListeners();
  }
}
