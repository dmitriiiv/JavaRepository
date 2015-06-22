package task38;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {

    public List<Point> parseXML(String wayToFile) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder;
        Document document = null;
        File file = new File(wayToFile);
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return doParsing(document);
    }

    private List<Point> doParsing(Document document) {
        List<Point> points = new ArrayList<>();
        Element pointsList = document.getDocumentElement();
        NodeList pointsNodeList = pointsList.getChildNodes();
        for (int i = 0; i < pointsNodeList.getLength(); i++) {
            if (pointsNodeList.item(i) instanceof Element) {
                Element pointElement = (Element) pointsNodeList.item(i);
                Point point = createPoint(pointElement);
                points.add(point);
            }
        }
        return points;
    }

    private Point createPoint(Element pointElement) {
        Point point = new Point();
        point.setUnit(getPointUnit(pointElement));
        NodeList childNodes = pointElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode instanceof Element) {
                Element childElement = (Element) childNode;
                if (isXTag(childElement)) {
                    point.setX(Integer.parseInt(childElement.getTextContent()));
                }
                if (isYTag(childElement)) {
                    point.setY(Integer.parseInt(childElement.getTextContent()));
                }
            }
        }
        return point;
    }

    private boolean isXTag(Element childElement) {
        return "x".equals(childElement.getTagName());
    }

    private boolean isYTag(Element childElement) {
        return "y".equals(childElement.getTagName());
    }

    private String getPointUnit(Element pointElement) {
        return pointElement.getAttribute("unit");
    }
}
