import 'package:flutter/material.dart';
import 'package:multi_select_flutter/multi_select_flutter.dart';
import 'package:sahabul_application/Models/property_model.dart';

class MultiselectWidget extends StatefulWidget {
  @override
  _MultiselectWidgetState createState() => _MultiselectWidgetState();
}

class _MultiselectWidgetState extends State<MultiselectWidget> {
  final _items = AttributesModel.attributes
      .map((attribute) => MultiSelectItem<Attribute>(attribute, attribute.name))
      .toList();

  List<Object?> selectedAttributes = [];

  @override
  void initState() {
    selectedAttributes = AttributesModel.attributes;
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(10),
      decoration: BoxDecoration(
        color: Color(0xff728840),
        borderRadius: BorderRadius.circular(15),
      ),
      child: Column(
        children: <Widget>[
          MultiSelectBottomSheetField(
            buttonIcon: Icon(
              Icons.arrow_drop_down_circle_outlined,
              color: Colors.white,
              size: 32,
            ),
            decoration: BoxDecoration(
              border: Border.all(color: Colors.transparent),
              borderRadius: BorderRadius.circular(15),
            ),
            initialChildSize: 0.4,
            listType: MultiSelectListType.CHIP,
            searchable: true,
            buttonText: Text(
              "Saha Özellikleri",
              style: TextStyle(
                fontSize: 18,
                color: Colors.white,
                fontWeight: FontWeight.w500,
              ),
            ),
            title: Text("Saha Özellikler,"),
            items: _items,
            onConfirm: (values) {
              selectedAttributes = values;
            },
            chipDisplay: MultiSelectChipDisplay(
              chipColor: Colors.white,
              textStyle: TextStyle(
                color: Color(0xff728840),
              ),
              onTap: (value) {
                setState(() {
                  selectedAttributes.remove(value);
                });
              },
            ),
          ),
        ],
      ),
    );
  }
}
