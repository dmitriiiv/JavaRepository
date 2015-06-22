package task38;

import java.util.List;

public class TaskTest {
    public static void main(String[] args) {
        DomParser parser = new DomParser();
        List<Point> points = parser.parseXML("./ivanchuk/src/task38/pointXsd.xml");
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
