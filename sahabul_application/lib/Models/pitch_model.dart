class PitchModel {
  static final pitchs = [
    Pitch(
      pitchName: 'Halisaha 0',
      address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
      telNumber: '05367625238',
      pictureUrl: [
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
      ],
    ),
    Pitch(
      pitchName: 'Halisaha 1',
      address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
      telNumber: '05367625238',
      pictureUrl: [
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
        'https://www.trtspor.com.tr/resimler/346000/347884.jpg',
        'https://foto.haberler.com/galeri/2014/07/24/hic-bitmeyen-halisaha-geyikleri_59528_b.jpg'
      ],
    ),
    Pitch(
      pitchName: 'Halisaha 2',
      address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
      telNumber: '05367625238',
      pictureUrl: [
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
        'https://www.trtspor.com.tr/resimler/346000/347884.jpg',
        'https://foto.haberler.com/galeri/2014/07/24/hic-bitmeyen-halisaha-geyikleri_59528_b.jpg'
      ],
    ),
    Pitch(
      pitchName: 'Halisaha 3',
      address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
      telNumber: '05367625238',
      pictureUrl: [
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
        'https://www.trtspor.com.tr/resimler/346000/347884.jpg',
        'https://foto.haberler.com/galeri/2014/07/24/hic-bitmeyen-halisaha-geyikleri_59528_b.jpg'
      ],
    ),
    Pitch(
      pitchName: 'Halisaha 4',
      address: 'Gönül Sokak no:23 Ortahisar/Trabzon',
      telNumber: '05367625238',
      pictureUrl: [
        'https://iatkv.tmgrup.com.tr/2337c6/600/314/2/0/637/332?u=https%3A%2F%2Fitkv.tmgrup.com.tr%2F2021%2F06%2F02%2Fhali-sahalar-acik-mi-kapali-mi-hali-saha-maclari-yasak-mi-serbest-mi-calisma-saatleri-1622630415537.jpg',
        'https://www.trtspor.com.tr/resimler/346000/347884.jpg',
        'https://foto.haberler.com/galeri/2014/07/24/hic-bitmeyen-halisaha-geyikleri_59528_b.jpg'
      ],
    ),
  ];
}

class Pitch {
  late String pitchName;
  late String address;
  late List<String> pictureUrl;
  late String telNumber;

  Pitch({
    required this.pitchName,
    required this.address,
    required this.pictureUrl,
    required this.telNumber,
  });
}
