package additionalTask11.parsers.impl;

import additionalTask11.entity.Bush;
import additionalTask11.entity.Plant;
import additionalTask11.entity.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {
    private List<Plant> plants = new ArrayList<>();
    private Plant plant;
    private boolean isName;
    private boolean isHeight;
    private boolean isBranchiness;
    private boolean isType;

    @Override
    public void startDocument() throws SAXException {
        plants.clear();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isBushTag(localName)) {
            plant = new Bush();
        } else if (isTreeTag(localName)) {
            plant = new Tree();
        } else if (isNameTag(localName)) {
            isName = true;
        } else if (isHeightTag(localName)) {
            isHeight = true;
        } else if (isTypeTag(localName)) {
            isType = true;
        } else if (isBranchinessTag(localName)) {
            isBranchiness = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isBushTag(localName) || isTreeTag(localName)) {
            plants.add(plant);
            plant = null;
        } else if (isNameTag(localName)) {
            isName = false;
        } else if (isHeightTag(localName)) {
            isHeight = false;
        } else if (isTypeTag(localName)) {
            isType = false;
        } else if (isBranchinessTag(localName)) {
            isBranchiness = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (isName) {
            plant.setName(value);
        } else if (isHeight) {
            plant.setHeight(Double.parseDouble(value));
        } else if (isType) {
            ((Tree) plant).setType(value);
        } else if (isBranchiness) {
            ((Bush) plant).setBranchiness(Integer.parseInt(value));
        }
    }

    public List<Plant> getPlants() {
        return plants;
    }

    private boolean isBushTag(String tagName) {
        return "bush".equals(tagName);
    }

    private boolean isTreeTag(String tagName) {
        return "tree".equals(tagName);
    }

    private boolean isNameTag(String tagName) {
        return "name".equals(tagName);
    }

    private boolean isHeightTag(String tagName) {
        return "height".equals(tagName);
    }

    private boolean isTypeTag(String tagName) {
        return "type".equals(tagName);
    }

    private boolean isBranchinessTag(String tagName) {
        return "branchiness".equals(tagName);
    }
}
