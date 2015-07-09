package task42.dao;


import task42.dto.Expense;

import java.util.List;

public interface ExpenseDAO {

    void addExpense(Expense expense);

    List findExpenses();
}
