import 'package:sahabul_application/Models/pitch_model.dart';

class RezervationModel {
  static final reservations = [
    Rezervation(
      pitch: PitchModel.pitchs[0],
      endHour: '12',
      startHour: '11',
      date: DateTime(2021, 12, 25),
    ),
    Rezervation(
      pitch: PitchModel.pitchs[1],
      endHour: '12',
      startHour: '11',
      date: DateTime(2021, 12, 25),
    ),
    Rezervation(
      pitch: PitchModel.pitchs[2],
      endHour: '12',
      startHour: '11',
      date: DateTime(2021, 12, 25),
    ),
    Rezervation(
      pitch: PitchModel.pitchs[3],
      endHour: '12',
      startHour: '11',
      date: DateTime(2021, 12, 25),
    ),
    Rezervation(
      pitch: PitchModel.pitchs[4],
      endHour: '12',
      startHour: '11',
      date: DateTime(2021, 12, 25),
    ),
  ];
}

class Rezervation {
  late Pitch pitch;
  late DateTime date;
  late String startHour;
  late String endHour;

  Rezervation({
    required this.date,
    required this.pitch,
    required this.endHour,
    required this.startHour,
  });
}
