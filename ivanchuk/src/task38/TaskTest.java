package task38;

//Напишите программу, которая будет разбирать xml файл,
//сделанный в предыдущих заданиях с помощью DOM, и выводить его на экран в текстовом виде.
//Каждая точка должна выводиться на отдельной строке в виде двух чисел, разделенных запятой,
//при этом должна выводиться единица измерения. Например: 10px, 30px

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
