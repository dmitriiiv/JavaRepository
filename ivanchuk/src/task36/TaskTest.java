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
        int i = 0;
        while (true) {
            try {
                ExceptionsGenerator.generate();
            } catch (Exception e) {
                logger.addLogRecord(Level.ERROR, "Logger message about exception", e);
            }
            if (i > 5) {
                break;
            }
            i++;
            try {
                logger.addLogRecord(Level.INFO, "Thread sleep 5 sec", null);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.addLogRecord(Level.ERROR, "Thread not sleep", e);
            }
        }
        logger.stopLogger();
    }
}
