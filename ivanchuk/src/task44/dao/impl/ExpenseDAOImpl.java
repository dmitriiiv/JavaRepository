package task44.dao.impl;

import task44.dao.ExpenseDAO;
import task44.dto.Expense;
import task44.units.DBUnits;

import java.sql.*;
import java.util.ArrayList;

public class ExpenseDAOImpl implements ExpenseDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/expenses_list";
    private final String USER_NAME = "root";
    private final String PASSWORD = "admin123";
    private final String SQL_INSERT_EXPENSE = "INSERT INTO expenses (id, pay_date, receiver, amount) VALUES(?,?,?,?); ";
    private final String SQL_SELECT_EXPENSES = "SELECT * FROM expenses;";
    private final String SQL_SELECT_EXPENSE = "SELECT * FROM expenses WHERE id = ?;";

    @Override
    public Expense getExpense(int num) {
        Expense expense = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.prepareStatement(SQL_SELECT_EXPENSE);
            statement.setInt(1, num);
            resultSet = statement.executeQuery();
            expense = createExpense(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUnits.close(connection, statement, resultSet);
        }
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        ArrayList<Expense> expenses = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_EXPENSES);
            expenses = initExpenses(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUnits.close(connection, statement, resultSet);
        }
        return expenses;
    }

    @Override
    public int addExpenses(Expense expense) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.prepareStatement(SQL_INSERT_EXPENSE);
            statement.setInt(1, expense.getId());
            statement.setString(2, expense.getPayDate());
            statement.setInt(3, expense.getReceiver());
            statement.setDouble(4, expense.getAmount());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUnits.close(connection, statement);
        }
        return expense.getId();
    }

    private Expense createExpense(ResultSet resultSet) throws SQLException {
        Expense expense = new Expense();
        while (resultSet.next()) {
            expense.setId(resultSet.getInt("id"));
            expense.setPayDate(resultSet.getString("pay_date"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setAmount(resultSet.getDouble("amount"));
        }
        return expense;
    }

    private ArrayList<Expense> initExpenses(ResultSet resultSet) throws SQLException {
        ArrayList<Expense> expenses = new ArrayList<>();
        while (resultSet.next()) {
            Expense expense = new Expense();
            expense.setId(resultSet.getInt("id"));
            expense.setPayDate(resultSet.getString("pay_date"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setAmount(resultSet.getDouble("amount"));
            expenses.add(expense);
        }
        return expenses;
    }
}
