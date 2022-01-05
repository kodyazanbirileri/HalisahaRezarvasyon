import 'package:flutter/material.dart';
import 'package:sahabul_application/models/pitch_model.dart';
import 'package:sahabul_application/services/pitch_service.dart';

class PitchData extends ChangeNotifier {
  List<PitchModel> pitches = [];

  void getAllByCityId(int cityId) async {
    pitches = await PitchService.getPitchesByCityId(cityId);
    notifyListeners();
  }
}
