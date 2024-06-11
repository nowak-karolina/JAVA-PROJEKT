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

    public List<Commodity> getData (String param){
        System.out.println("Get data sql " + param);
        List<Commodity> commodities = new ArrayList<>();
        try{

            String query = "SELECT * FROM commodity WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, param);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String exchange = resultSet.getString("exchange");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                long updated = resultSet.getLong("updated");

                Commodity commodity = new Commodity(exchange, name, price, updated);
                commodities.add(commodity);
                System.out.println("Pobrano dane z sql");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return commodities;
    }

    public int addToDB(Commodity commodity) {
        String query = "INSERT INTO commodity (exchange, name, price, updated) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, commodity.exchange);
            preparedStatement.setString(2, commodity.name);
            preparedStatement.setFloat(3, commodity.price);
            preparedStatement.setLong(4, commodity.updated);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Dodano do db");
            return rowsAffected > 0 ? 0 : 1;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
}
