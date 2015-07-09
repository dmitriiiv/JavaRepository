package additionalTask11.parsers.impl;

import additionalTask11.entity.Bush;
import additionalTask11.entity.Plant;
import additionalTask11.entity.Tree;
import additionalTask11.parsers.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements XMLParser {
    @Override
    public List<Plant> parseXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder;
        Document document = null;
        File file = new File(XML_FILE);
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return doParsing(document);
    }

    private List<Plant> doParsing(Document document) {
        List<Plant> plants = new ArrayList<>();
        Element plantsTag = document.getDocumentElement();
        NodeList plantNodes = plantsTag.getChildNodes();
        for (int i = 0; i < plantNodes.getLength(); i++) {
            if (plantNodes.item(i) instanceof Element) {
                Element plantTag = (Element) plantNodes.item(i);
                Plant plant = createPlant(plantTag);
                plants.add(plant);
            }
        }
        return plants;
    }

    private Plant createPlant(Element plantTag) {
        Plant plant = null;
        NodeList plantNodes = plantTag.getChildNodes();
        for (int i = 0; i < plantNodes.getLength(); i++) {
            if (plantNodes.item(i) instanceof Element) {
                Element childElement = (Element) plantNodes.item(i);
                if (isTreeTag(childElement)) {
                    plant = createTree(childElement);
                } else if (isBushTag(childElement)) {
                    plant = createBush(childElement);
                }
            }
        }
        return plant;
    }

    private Plant createTree(Element plantElement) {
        Plant tree = new Tree();
        NodeList childNodes = plantElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                Element childElement = (Element) childNodes.item(i);
                if (isNameTag(childElement)) {
                    tree.setName(getPlantName(childElement));
                } else if (isHeightTag(childElement)) {
                    tree.setHeight(getPlantHeight(childElement));
                } else if (isTypeTag(childElement)) {
                    ((Tree) tree).setType(getTreeType(childElement));
                }
            }
        }
        return tree;
    }

    private Plant createBush(Element plantElement) {
        Plant bush = new Bush();
        NodeList childNodes = plantElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                Element childElement = (Element) childNodes.item(i);
                if (isNameTag(childElement)) {
                    bush.setName(getPlantName(childElement));
                } else if (isHeightTag(childElement)) {
                    bush.setHeight(getPlantHeight(childElement));
                } else if (isBranchinessTag(childElement)) {
                    ((Bush) bush).setBranchiness(getBushBranchiness(childElement));
                }
            }
        }
        return bush;
    }

    private String getPlantName(Element tag) {
        return tag.getTextContent();
    }

    private double getPlantHeight(Element tag) {
        return Double.parseDouble(tag.getTextContent());
    }

    private String getTreeType(Element tag) {
        return tag.getTextContent();
    }

    private int getBushBranchiness(Element tag) {
        return Integer.parseInt(tag.getTextContent());
    }

    private boolean isTreeTag(Element tag) {
        return "pl:tree".equals(tag.getTagName());
    }

    private boolean isBushTag(Element tag) {
        return "pl:bush".equals(tag.getTagName());
    }

    private boolean isNameTag(Element tag) {
        return "pl:name".equals(tag.getTagName());
    }

    private boolean isHeightTag(Element tag) {
        return "pl:height".equals(tag.getTagName());
    }

    private boolean isTypeTag(Element tag) {
        return "pl:type".equals(tag.getTagName());
    }

    private boolean isBranchinessTag(Element tag) {
        return "pl:branchiness".equals(tag.getTagName());
    }
}
