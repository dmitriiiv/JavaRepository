package task36;

import java.util.Date;

public class HtmlFormatter {

    public String getHead() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<style>\n" +
                "\t\t.line{font-size: 80%}\n" +
                "\t</style>\n" +
                "\t<title>Logger file</title>\n" +
                "</head>\n" +
                "<body bgcolor=\"#f5f5dc\">\n" +
                "\t<h2 align=\"center\">LOGGER FILE</h2>\n" +
                "\t<table border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"5\">\n" +
                "\t\t<tr bgcolor=\"#f0f8ff\">\n" +
                "\t\t\t<th>Date</th>\n" +
                "\t\t\t<th>Level</th>\n" +
                "\t\t\t<th>Class</th>\n" +
                "\t\t\t<th>Method</th>\n" +
                "\t\t\t<th>Message</th>\n" +
                "\t\t\t<th>Thrown message</th>\n" +
                "\t\t\t<th width=\"40%\">StackTrace</th>\n" +
                "\t\t</tr>\n";
    }

    public String format(Level level, String message, Exception e) {
        return "\t\t<tr class=\"line\" bgcolor=\"" +
                level.getColor() +
                "\">\n" +
                getDateCell() +
                getLevelCell(level) +
                getClassCell(e) +
                getMethodCell(e) +
                getMessageCell(message) +
                getThrownMessageCell(e) +
                getStackTraceCell(e) +
                "\t\t</tr>\n";
    }

    public String getTail() {
        return "\t</table>\n" +
                "</body>\n" +
                "</html>";
    }

    private String getDateCell() {
        return "\t\t\t<td align=\"center\">" +
                new Date() +
                "</td>\n";
    }

    private String getLevelCell(Level level) {
        return "\t\t\t<td align=\"center\">" +
                level.name() +
                "</td>\n";
    }

    private String getClassCell(Exception e) {
        String text = getClass().getName();
        if (e != null) {
            StackTraceElement[] elements = e.getStackTrace();
            text = elements[0].getClassName();
        }
        return "\t\t\t<td>" +
                text +
                "</td>\n";
    }

    private String getMethodCell(Exception e) {
        String text = "&nbsp;";
        if (e != null) {
            StackTraceElement[] elements = e.getStackTrace();
            text = elements[0].getMethodName();
        }
        return "\t\t\t<td>" +
                text +
                "</td>\n";
    }

    private String getMessageCell(String message) {
        if (message.length() == 0) {
            message = "&nbsp;";
        }
        return "\t\t\t<td>" +
                message +
                "</td>\n";
    }

    private String getThrownMessageCell(Exception e) {
        String text = "&nbsp;";
        if (e != null) {
            text = e.getMessage();
        }
        return "\t\t\t<td>" +
                text +
                "</td>\n";
    }

    private String getStackTraceCell(Exception e) {
        StringBuilder stackTrace = new StringBuilder();
        if (e != null) {
            stackTrace.append("\t\t\t\t").append(e).append("<br/>\n");
            StackTraceElement[] elements = e.getStackTrace();
            for (int i = 0; i < elements.length - 5; i++) {
                stackTrace.append("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;");
                stackTrace.append(elements[i]);
                stackTrace.append("<br/>\n");
            }
        }
        return "\t\t\t<td>\n" +
                stackTrace +
                "\t\t\t</td>\n";
    }
}
