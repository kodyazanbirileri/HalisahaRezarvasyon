import 'package:sahabul_application/models/pitch_reservation_model.dart';

class PitchModel {
  late String address;
  late String city;
  late String district;
  late int id;
  String? pitchNumber;
  late String pitchName;
  List<dynamic>? pitchPhotos;
  List<dynamic>? pitchProperties;
  List<dynamic>? reservations;

  PitchModel(
      {required this.pitchName,
      required this.address,
      required this.id,
      required this.city,
      required this.pitchNumber,
      required this.district,
      required this.pitchPhotos,
      required this.pitchProperties,
      required this.reservations});

  factory PitchModel.fromMap(Map pitchModelMap) {
    return PitchModel(
        pitchName: pitchModelMap['pitchName'],
        address: pitchModelMap['address'],
        id: pitchModelMap['id'],
        city: pitchModelMap['city'],
        pitchNumber: pitchModelMap['pitchNumber'],
        district: pitchModelMap['district'],
        pitchProperties: pitchModelMap['pitchProperties']
            .map((pp) => pp.toString())
            .toList(),
        pitchPhotos: pitchModelMap['pitchPhotos'],
        reservations: pitchModelMap['reservations']
            .map((taskMap) => PitchReservationModel.fromMap(taskMap))
            .toList());
  }
}
