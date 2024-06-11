package org.example;

import java.sql.Date;
import java.sql.Timestamp;

public class Commodity {
    public String exchange;
    public String name;
    public float price;
    public long updated;

    public Commodity(String exchange, String name, float price, long updated) {
        this.exchange = exchange;
        this.name = name;
        this.price = price;
        this.updated = updated;
    }


    @Override
    public String toString() {
        return "Commodity{" +
                "exchange='" + exchange + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", updated=" + updated +
                '}';
    }
}
