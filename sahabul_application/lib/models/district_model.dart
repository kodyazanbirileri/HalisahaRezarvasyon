class DistrictModel {
  late int id;
  late String cityName;
  late String districtName;

  DistrictModel({
    required this.id,
    required this.cityName,
    required this.districtName,
  });

  factory DistrictModel.fromMap(Map districtMap) {
    return DistrictModel(
      id: districtMap['id'],
      cityName: districtMap['cityName'],
      districtName: districtMap['districtName'],
    );
  }

  get getDistrictName => districtName;
}
