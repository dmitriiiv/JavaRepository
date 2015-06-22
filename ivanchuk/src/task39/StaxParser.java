package task39;

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

public class StaxParser {

    public List<Point> parse(String fileWay) {
        List<Point> points = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileWay);
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
            points = doParsing(reader);
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
        return points != null ? points : Collections.<Point>emptyList();
    }

    private List<Point> doParsing(XMLStreamReader reader) throws XMLStreamException {
        Point point = null;
        boolean isX = false;
        boolean isY = false;
        List<Point> points = new ArrayList<>();
        while (reader.hasNext()) {
            int node = reader.next();
            if (node == XMLStreamConstants.START_ELEMENT) {
                if (isPointTag(reader)) {
                    point = new Point();
                    point.setUnit(reader.getAttributeValue(0));
                } else if (isXTag(reader)) {
                    isX = true;
                } else if (isYTag(reader)) {
                    isY = true;
                }

            } else if (node == XMLStreamConstants.CHARACTERS) {
                if (point != null) {
                    if (isX && !reader.isWhiteSpace()) {
                        point.setX(Integer.parseInt(reader.getText()));
                        isX = false;
                    } else if (isY && !reader.isWhiteSpace()) {
                        point.setY(Integer.parseInt(reader.getText()));
                        isY = false;
                    }
                }
            } else if (node == XMLStreamConstants.END_ELEMENT) {
                if (isPointTag(reader)) {
                    points.add(point);
                    point = null;
                }
            }
        }
        return points;
    }

    private boolean isPointTag(XMLStreamReader reader) {
        return "point".equals(reader.getLocalName());
    }

    private boolean isXTag(XMLStreamReader reader) {
        return "x".equals(reader.getLocalName());
    }

    private boolean isYTag(XMLStreamReader reader) {
        return "y".equals(reader.getLocalName());
    }
}

