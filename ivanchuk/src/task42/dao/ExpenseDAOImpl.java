package task42.dao;

import task42.dto.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/expenses_list";
    private final String USER_NAME = "root";
    private final String PASSWORD = "admin123";
    private final String SQL_INSERT_EXPENSE = "INSERT INTO expenses (pay_date, receiver, amount) VALUES(?,?,?);";
    private final String SQL_SELECT_EXPENSES = "SELECT pay_date, receiver, amount FROM expenses;";

    @Override
    public void addExpense(Expense expense) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_EXPENSE);
            statement.setString(1, expense.getPayDate());
            statement.setInt(2, expense.getReceiver());
            statement.setDouble(3, expense.getAmount());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Expense> findExpenses() {
        List<Expense> expenses = null;
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_EXPENSES);
            expenses = initExpenses(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return expenses != null ? expenses : Collections.<Expense>emptyList();
    }

    private List<Expense> initExpenses(ResultSet resultSet) throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        while (resultSet.next()) {
            Expense expense = new Expense();
            expense.setPayDate(resultSet.getString("pay_date"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setAmount(resultSet.getDouble("amount"));
            expenses.add(expense);
        }
        return expenses;
    }
}
