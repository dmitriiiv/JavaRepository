package task36;

import java.io.*;

public class HtmlLogger {
    private static HtmlLogger instance;
    private HtmlFormatter formatter;
    private final File LOG_FILE = new File("./ivanchuk/src/task36/log.html");

    private HtmlLogger() {
        formatter = new HtmlFormatter();
        startLogger();
    }

    public static HtmlLogger getLogger() {
        if (instance == null) {
            instance = new HtmlLogger();
        }
        return instance;
    }

    private void startLogger() {
        writeFile(formatter.getHead(), true);
        writeFile(formatter.format(Level.INFO, "Logger is started", null), false);
    }

    private void writeFile(String text, boolean isRewrite) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(LOG_FILE, !isRewrite));
            out.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void addLogRecord(Level level, String message, Exception e) {
        writeFile(formatter.format(level, message, e), false);
    }

    public void stopLogger() {
        writeFile(formatter.format(Level.WARNING, "Logger is stopped", null), false);
        writeFile(formatter.getTail(), false);
    }

    public int getError() {
        int[] array = {2};
        try {
            array[1] = 2;
        } catch (Exception e) {
            addLogRecord(Level.ERROR, "This is first error", e);
        }
        return array[0];
    }

    public void getSecondError() throws Exception {
        formatter.getSecondError();
    }
}
