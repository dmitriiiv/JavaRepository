package task40;

//Напишите программу, преобразующую созданный в предыдущих заданиях xml файл в html,
//аналогично данному примеру, в каждой ячейке дополнительно к координате должны выводиться единицы измерения.
//Результат должен записываться в файл на диске.

public class TaskTest {
    public static void main(String[] args) {
        XMLTransformer transformer = new XMLTransformer();
        String directory = "./ivanchuk/src/task40";
        transformer.transform(directory + "/transformer.xsl",
                directory + "/pointXsd.xml",
                directory + "/result.html");
    }
}
