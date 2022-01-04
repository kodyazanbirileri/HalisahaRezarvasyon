import 'package:sahabul_application/Models/pitch_reservation_model.dart';
import 'package:sahabul_application/Models/reservation_model.dart';

class PitchModel {
  late String address;
  late String city;
  late String district;
  late int id;
  late String pitchName;
  late List<String> pitchPhotos;
  late List<String> pitchProperties;
  late List<PitchReservationModel> reservations;

  PitchModel(
      {required this.pitchName,
      required this.address,
      required this.id,
      required this.city,
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
        district: pitchModelMap['district'],
        pitchProperties: pitchModelMap['pitchProperties'],
        pitchPhotos: pitchModelMap['pitchPhotos'],
        reservations: pitchModelMap['reservations']
            .map((taskMap) => ReservationModel.fromMap(taskMap))
            .toList());
  }
}
