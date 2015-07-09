package task42;

//Напишите программу получающую данные о расходе в качестве исходных параметров main,
//и добавляющую этот расход в базу, после чего выводящую таблицу расходов на экран.

import task42.dto.Expense;
import task42.service.ExpenseService;

import java.util.List;
import java.util.Scanner;

public class TaskTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату(гггг-мм-дд)");
        String date = scanner.nextLine();
        System.out.println("Введите получателя");
        int receiver = scanner.nextInt();
        System.out.println("Введите сумму");
        double amount = scanner.nextDouble();
        ExpenseService service = new ExpenseService();
        service.addExpense(date, receiver, amount);
        List<Expense> expenses = service.findExpenses();
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }
}
