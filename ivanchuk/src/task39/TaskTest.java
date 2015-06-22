package task39;

//Напишите программу, которая будет разбирать xml файл,
//сделанный в предыдущих заданиях с помощью StAX,
//и выводить его на экран в текстовом виде.
//Каждая точка должна выводиться на отдельной строке в виде двух чисел,
//разделенных запятой, при этом должна выводиться еди-ница измерения.
//Например: 10px, 30px

import java.util.List;

public class TaskTest {
    public static void main(String[] args) {
        STAXParser parser = new STAXParser();
        List<Point> points = parser.parse("./ivanchuk/src/task39/pointXsd.xml");
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
