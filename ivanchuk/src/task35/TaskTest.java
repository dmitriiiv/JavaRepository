package task35;

//Создать программу, которая может приветствовать пользователя на трех языках: английском, русском, белорусском.
//Требуемый язык и страна должны сообщаться программе в качестве входных параметров.
//Если входные параметры отсутствуют, программа должна выдавать сообщение на английском.

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TaskTest {
    public static void main(String[] args) {
        System.out.println("Введите страну( US, RU, BY)");
        Scanner in = new Scanner(System.in);
        String loc = in.nextLine();
        Locale locale;
        if (loc.equals("RU") || loc.equals("BY") || loc.equals("US")) {
            locale = Locations.valueOf(loc).getLocation();
        } else {
            locale = Locations.US.getLocation();
        }
        System.out.println(ResourceBundle.getBundle("task35/MessagesBundle", locale).getString("greeting"));
    }
}
