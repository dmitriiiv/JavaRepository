package additionalTask11.parsers;

import additionalTask11.entity.Plant;

import java.util.List;

public interface XMLParser {
    String XML_FILE = "./ivanchuk/src/additionalTask11/xmlFiles/plants.xml";

    List<Plant> parseXML();
}

