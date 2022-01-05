class CityModel {
  late int id;
  late String cityName;

  CityModel({
    required this.id,
    required this.cityName,
  });

  factory CityModel.fromMap(Map cityMap) {
    return CityModel(
      id: cityMap['id'],
      cityName: cityMap['cityName'],
    );
  }
}
