package additionalTask11.parsers.impl;

import additionalTask11.entity.Plant;
import additionalTask11.parsers.XMLParser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SAXParser implements XMLParser {
    @Override
    public List<Plant> parseXML() {
        List<Plant> categories = null;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler saxParserHandler = new SAXParserHandler();
            reader.setContentHandler(saxParserHandler);
            InputSource source = new InputSource(XML_FILE);
            reader.parse(source);
            categories = saxParserHandler.getPlants();
        } catch (SAXException | IOException e) {
            System.out.println("ParsingException");
            e.printStackTrace();
        }
        return categories;
    }
}
