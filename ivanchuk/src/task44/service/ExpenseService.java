package task44.service;

import task44.dao.ExpenseDAO;
import task44.dao.impl.ExpenseDAOImpl;
import task44.dto.Expense;

import java.util.ArrayList;

public class ExpenseService {
    private ExpenseDAO expenseDAO = new ExpenseDAOImpl();

    public Expense getExpense(int number) {
        return expenseDAO.getExpense(number);
    }

    public ArrayList<Expense> getExpenses() {
        return expenseDAO.getExpenses();
    }

    public int addExpenses(Expense expense) {
        return expenseDAO.addExpenses(expense);
    }
}
