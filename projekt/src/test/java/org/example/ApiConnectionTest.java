package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiConnectionTest {

    @Test
    public void CorrectName(){
        ApiConnection connection = new ApiConnection();

        for(eCommodity eCommodity: eCommodity.values()){
            Commodity commodity = connection.getCommodity(eCommodity.getValue());
            assertEquals(eCommodity.getName(), commodity.name);
        }
    }


}