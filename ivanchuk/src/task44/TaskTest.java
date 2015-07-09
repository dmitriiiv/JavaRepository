package task44;

import task44.dto.Expense;
import task44.dto.Receiver;
import task44.service.ExpenseService;
import task44.service.ReceiverService;

public class TaskTest {

    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();
        Expense newExpense = new Expense();
        newExpense.setId(12);
        newExpense.setPayDate("2015-2-3");
        newExpense.setReceiver(1);
        newExpense.setAmount(8000);
        expenseService.addExpenses(newExpense);
        for (Expense expense : expenseService.getExpenses()) {
            System.out.println(expense);
        }
        System.out.println("new expense - " + expenseService.getExpense(12));
        ReceiverService receiverService = new ReceiverService();
        Receiver newReceiver = new Receiver();
        newReceiver.setId(4);
        newReceiver.setName("Аптека №4");
        receiverService.addReceiver(newReceiver);
        for (Receiver receiver : receiverService.getReceivers()) {
            System.out.println(receiver);
        }
        System.out.println("new receiver - " + receiverService.getReceiver(4));
    }
}
