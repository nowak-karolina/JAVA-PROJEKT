package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLConnection {
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/java?serverTimezone=UTC";
    private final static String DBUSER = "root";
    private final static String DBPASS = "dupa";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";

    private Connection connection;

    public SQLConnection() {
        try{
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Commodity> getData (){
        List<Commodity> commodities = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from commodity");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String exchange = resultSet.getString("exchange");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                long updated = resultSet.getLong("updated");
                Timestamp time = resultSet.getTimestamp("time");

                Commodity commodity = new Commodity(exchange, name, price, updated, time);
                commodities.add(commodity);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return commodities;
    }

    public int addToDB(Commodity commodity) {
        String query = "INSERT INTO commodity (exchange, name, price, updated, time) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, commodity.exchange);
            preparedStatement.setString(2, commodity.name);
            preparedStatement.setFloat(3, commodity.price);
            preparedStatement.setLong(4, commodity.updated);
            preparedStatement.setTimestamp(5, commodity.time);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0 ? 0 : 1;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
}
