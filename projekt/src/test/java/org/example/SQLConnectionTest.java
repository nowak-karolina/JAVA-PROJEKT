package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLConnectionTest {
    @Test
    public void AddedToDb(){
        SQLConnection sqlConnection = new SQLConnection();
        ApiConnection apiConnection = new ApiConnection();
        Commodity commodity = apiConnection.getCommodity(eCommodity.COCOA.getValue());
        int result = sqlConnection.addToDB(commodity);
        assertEquals(result,0);
    }

    @Test
    public void ReadFromDb(){
        SQLConnection sqlConnection = new SQLConnection();
        List<Commodity> commodities = sqlConnection.getData(eCommodity.COCOA.getName());

        assertTrue(commodities.size()>0);
    }
}