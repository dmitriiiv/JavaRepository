package task36;

//Создать простейший логгер, выводящий сообщения об ошибках в тестовый файл.
//Объект логгера должен быть создан с помощью ШП Singleton.
//У объекта должен быть обязательным один метод, получающий на вход текст сообщения
//об ошибке и записывающий его в файл вместе с информацией о дате и времени проишествия.

public class TaskTest {
    public static void main(String[] args) {
        HtmlLogger logger = HtmlLogger.getLogger();
        try {
            throw new Exception("Message in exception");
        } catch (Exception e) {
            logger.addLogRecord(Level.ERROR, "Logger message about exception", e);
        }
        logger.getError();
        try {
            logger.getSecondError();
        } catch (Exception e) {
            logger.addLogRecord(Level.ERROR, "This is second error", e);
        }
        logger.stopLogger();
    }
}
