class PropertyModel {
  late int id;
  late String propertyName;

  PropertyModel({
    required this.id,
    required this.propertyName,
  });

  factory PropertyModel.fromMap(Map propertyMap) {
    return PropertyModel(
        id: propertyMap['id'], propertyName: propertyMap['propertyName']);
  }
}
