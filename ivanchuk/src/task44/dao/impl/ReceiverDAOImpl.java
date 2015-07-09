package task44.dao.impl;

import task44.dao.ReceiverDAO;
import task44.dto.Receiver;
import task44.units.DBUnits;

import java.sql.*;
import java.util.ArrayList;

public class ReceiverDAOImpl implements ReceiverDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/expenses_list";
    private final String USER_NAME = "root";
    private final String PASSWORD = "admin123";
    private final String SQL_INSERT_RECEIVER = "INSERT INTO receivers (id, name) VALUES(?,?);";
    private final String SQL_SELECT_RECEIVERS = "SELECT * FROM receivers;";
    private final String SQL_SELECT_RECEIVER = "SELECT * FROM receivers WHERE id = ?;";

    @Override
    public Receiver getReceiver(int num) {
        Receiver receiver = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.prepareStatement(SQL_SELECT_RECEIVER);
            statement.setInt(1, num);
            resultSet = statement.executeQuery();
            receiver = createReceiver(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUnits.close(connection, statement, resultSet);
        }
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() {
        ArrayList<Receiver> receivers = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_RECEIVERS);
            receivers = initReceivers(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUnits.close(connection, statement, resultSet);
        }
        return receivers;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.prepareStatement(SQL_INSERT_RECEIVER);
            statement.setInt(1, receiver.getId());
            statement.setString(2, receiver.getName());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBUnits.close(connection, statement);
        }
        return receiver.getId();
    }

    private Receiver createReceiver(ResultSet resultSet) throws SQLException {
        Receiver receiver = new Receiver();
        while (resultSet.next()) {
            receiver.setId(resultSet.getInt("id"));
            receiver.setName(resultSet.getString("name"));
        }
        return receiver;
    }

    private ArrayList<Receiver> initReceivers(ResultSet resultSet) throws SQLException {
        ArrayList<Receiver> receivers = new ArrayList<>();
        while (resultSet.next()) {
            Receiver receiver = new Receiver();
            receiver.setId(resultSet.getInt("id"));
            receiver.setName(resultSet.getString("name"));
            receivers.add(receiver);
        }
        return receivers;
    }
}
