class HoursModel {
  late int id;
  late int endHour;
  late int startHour;

  HoursModel({
    required this.id,
    required this.endHour,
    required this.startHour,
  });

  factory HoursModel.fromMap(Map hoursModelMap) {
    return HoursModel(
        id: hoursModelMap['id'],
        endHour: hoursModelMap['endHour'],
        startHour: hoursModelMap['startHour']);
  }
}
