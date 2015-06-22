package task40;

//Напишите программу, преобразующую созданный в предыдущих заданиях xml файл в html,
//аналогично данному примеру, в каждой ячейке дополнительно к координате должны выводиться единицы измерения.
//Результат должен записываться в файл на диске.

public class TaskTest {
    public static void main(String[] args) {
        XMLTransformer transformer = new XMLTransformer();
        String wayXslFile = "./ivanchuk/src/task40/transformer.xsl";
        String wayXmlFile = "./ivanchuk/src/task40//pointXsd.xml";
        String wayHtmlFile = "./ivanchuk/src/task40//result.html";
        transformer.transform(wayXslFile, wayXmlFile, wayHtmlFile);
    }
}
