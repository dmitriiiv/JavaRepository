package additionalTask11;

//Импортировать из XML-файла информацию о парковых растениях.
//Определить иерархию деревьев и кустарников. Посадить парк.
//Посчитать число насаждений и их общую высоту.
//Результаты экспортировать в XML-файл.


import additionalTask11.entity.Plant;
import additionalTask11.parsers.ParserFactory;
import additionalTask11.parsers.ParserType;
import additionalTask11.parsers.XMLParser;

import java.util.List;

public class TaskTest {
    public static void main(String[] args) {
        XMLParser parser = ParserFactory.getParser(ParserType.SAX);
        List<Plant> plants = parser.parseXML();
        for (Plant plant : plants) {
            System.out.print(plant);
            plant.grow();
            System.out.print(plant + "\n");
        }
    }
}
