package additionalTask11.parsers.impl;

import additionalTask11.entity.Bush;
import additionalTask11.entity.Plant;
import additionalTask11.entity.Tree;
import additionalTask11.parsers.XMLParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class STAXParser implements XMLParser {
    private List<Plant> plants = new ArrayList<>();
    private Plant plant = null;
    private boolean isName;
    private boolean isHeight;
    private boolean isBranchiness;
    private boolean isType;

    @Override
    public List<Plant> parseXML() {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        FileInputStream inputStream = null;
        List<Plant> plants = null;
        try {
            inputStream = new FileInputStream(XML_FILE);
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
            plants = doParsing(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return plants != null ? plants : Collections.<Plant>emptyList();
    }

    private List<Plant> doParsing(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int node = reader.next();
            if (node == XMLStreamConstants.START_ELEMENT) {
                processStartElement(reader);
            } else if (node == XMLStreamConstants.CHARACTERS) {
                processCharacters(reader);
            } else if (node == XMLStreamConstants.END_ELEMENT) {
                processEndElement(reader);
            }
        }
        return plants;
    }

    private void processStartElement(XMLStreamReader reader) {
        if (isBushTag(reader)) {
            plant = new Bush();
        } else if (isTreeTag(reader)) {
            plant = new Tree();
        } else if (isNameTag(reader)) {
            isName = true;
        } else if (isHeightTag(reader)) {
            isHeight = true;
        } else if (isTypeTag(reader)) {
            isType = true;
        } else if (isBranchinessTag(reader)) {
            isBranchiness = true;
        }
    }

    private void processCharacters(XMLStreamReader reader) {
        if (isName) {
            plant.setName(reader.getText());
        } else if (isHeight) {
            plant.setHeight(Double.parseDouble(reader.getText()));
        } else if (isType) {
            ((Tree) plant).setType(reader.getText());
        } else if (isBranchiness) {
            ((Bush) plant).setBranchiness(Integer.parseInt(reader.getText()));
        }
    }

    private void processEndElement(XMLStreamReader reader) {
        if (isBushTag(reader) || isTreeTag(reader)) {
            plants.add(plant);
            plant = null;
        } else if (isNameTag(reader)) {
            isName = false;
        } else if (isHeightTag(reader)) {
            isHeight = false;
        } else if (isTypeTag(reader)) {
            isType = false;
        } else if (isBranchinessTag(reader)) {
            isBranchiness = false;
        }
    }

    private boolean isTreeTag(XMLStreamReader reader) {
        return "tree".equals(reader.getLocalName());
    }

    private boolean isBushTag(XMLStreamReader reader) {
        return "bush".equals(reader.getLocalName());
    }

    private boolean isNameTag(XMLStreamReader reader) {
        return "name".equals(reader.getLocalName());
    }

    private boolean isHeightTag(XMLStreamReader reader) {
        return "height".equals(reader.getLocalName());
    }

    private boolean isTypeTag(XMLStreamReader reader) {
        return "type".equals(reader.getLocalName());
    }

    private boolean isBranchinessTag(XMLStreamReader reader) {
        return "branchiness".equals(reader.getLocalName());
    }
}
