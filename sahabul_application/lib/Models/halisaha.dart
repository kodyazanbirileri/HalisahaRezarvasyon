class PitchModel {
  static final Pitchs = [
    Pitch(
        pitch_name: 'Halisaha 1',
        address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
        tel_number: '05367625238',
        picture_url: [
          'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
          'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
          'https://lh3.googleusercontent.com/proxy/zM4PyW6iddlMZmnFFY-0jyvmHKgzjTnxG12yyutSOHZ-1UKSq0CjrUO8AHlRKvk9-uPMhkD67CLSgV70GAxGzRHR6y-gbfJu7H8VCdTiJZ20fszGKAWcZIChGvl6on5MLToClyWGlm-_z3LJmjkbwNJwAqSu2s_E65YTissAMDSBXA',
        ]),
    Pitch(
      pitch_name: 'Halisaha 2',
      address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
      tel_number: '05367625238',
      picture_url: [
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
        'https://www.trtspor.com.tr/resimler/346000/347884.jpg',
        'https://foto.haberler.com/galeri/2014/07/24/hic-bitmeyen-halisaha-geyikleri_59528_b.jpg'
      ],
    ),
  ];
}

class Pitch {
  late String pitch_name;
  late String address;
  late List<String> picture_url;
  late String tel_number;

  Pitch({
    required this.pitch_name,
    required this.address,
    required this.picture_url,
    required this.tel_number,
  });
}
