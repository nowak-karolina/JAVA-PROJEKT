package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ApiConnection {
    private URL url;
    private String key;

    public ApiConnection() {
        try {
            this.url = new URL("https://api.api-ninjas.com/v1/commodityprice?name=");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.key = "XmFJ/gDR3L9o3vAPnOtdWg==Ub7hwlP5RRxACpnZ";
    }


    public Commodity getCommodity(String parameter)  {
        try{
            URL link = new URL(url.toString() + parameter);
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-API-Key", key);

            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            connection.disconnect();
            //System.out.println("Pobrano jsona z api");

            return parseJsonToCommodity(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Commodity parseJsonToCommodity(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        String exchange = jsonObject.get("exchange").getAsString();
        String name = jsonObject.get("name").getAsString();
        float price = jsonObject.get("price").getAsFloat();
        long updated = jsonObject.get("updated").getAsLong();
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //System.out.println("sparsowano jsona do klasy");
        return new Commodity(exchange, name, price, updated);
    }
}
