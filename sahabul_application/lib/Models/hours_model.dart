class HoursModel {
  static final hours = [
    Hours(hour: '12-13'),
    Hours(hour: '13-14'),
    Hours(hour: '14-15'),
    Hours(hour: '15-16'),
    Hours(hour: '16-17'),
    Hours(hour: '17-18'),
    Hours(hour: '18-19'),
    Hours(hour: '19-20'),
    Hours(hour: '20-21'),
    Hours(hour: '21-22'),
    Hours(hour: '22-23'),
    Hours(hour: '23-00'),
    Hours(hour: '00-01'),
    Hours(hour: '01-02'),
    Hours(hour: '02-03'),
  ];
}

class Hours {
  late int id;
  late String hour;

  Hours({required this.hour});
}

class HoursArguments {
  late Hours hours;

  HoursArguments({required this.hours});
}
