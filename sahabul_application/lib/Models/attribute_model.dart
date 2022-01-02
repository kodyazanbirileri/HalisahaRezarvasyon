class AttributesModel {
  static final attributes = [
    Attribute(id: 1, name: "Kafetarya"),
    Attribute(id: 2, name: "Duş"),
    Attribute(id: 3, name: "Servis"),
    Attribute(id: 4, name: "Otopark"),
    Attribute(id: 5, name: "Skorboard"),
    Attribute(id: 6, name: "Üstü kapalı"),
    Attribute(id: 7, name: "Çay servesi"),
    Attribute(id: 8, name: "Ayakkabı-Eldiven imkanı"),
  ];
}

class Attribute {
  late String name;
  late int id;

  Attribute({required this.id, required this.name});
}
