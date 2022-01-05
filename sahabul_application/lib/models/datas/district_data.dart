import 'package:flutter/material.dart';
import 'package:sahabul_application/models/district_model.dart';
import 'package:sahabul_application/services/district_service.dart';

class DistrictData extends ChangeNotifier {
  List<DistrictModel> districts = [];

  void getAllById(int id) async {
    districts = await DistrictService.getDistrictByCityId(id);
    print(districts);
    notifyListeners();
  }
}
