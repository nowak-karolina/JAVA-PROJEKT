package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ApiConnection apiConnection = new ApiConnection();
            Commodity commodity = apiConnection.getCommodity(eCommodity.MICRO_SILVER_FUTURES.getValue());
            SQLConnection sqlConnection = new SQLConnection();
            int result = sqlConnection.addToDB(commodity);
            if (result == 0) {
                System.out.println("Commodity added to database successfully.");
            } else {
                System.out.println("Failed to add commodity to database.");
            }
            List<Commodity> commodities = sqlConnection.getData(commodity.name);

            for (Commodity commodity1 : commodities) {
                System.out.println(commodity1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}