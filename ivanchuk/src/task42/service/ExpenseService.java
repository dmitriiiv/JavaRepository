package task42.service;

import task42.dao.ExpenseDAO;
import task42.dao.ExpenseDAOImpl;
import task42.dto.Expense;

import java.util.List;

public class ExpenseService {
    ExpenseDAO expenseDAO = new ExpenseDAOImpl();

    public void addExpense(String date, int receiver, double amount) {
        Expense expense = new Expense(date, receiver, amount);
        expenseDAO.addExpense(expense);
    }

    public List<Expense> findExpenses() {
        return expenseDAO.findExpenses();
    }
}