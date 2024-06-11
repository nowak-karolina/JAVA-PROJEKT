package org.example;

public enum eCommodities {
    GOLD_FUTURES("Gold%20Futures"),
    SOYBEAN_OIL_FUTURES("Soybean%20Oil%20Futures"),
    WHEAT_FUTURES("Wheat%20Futures"),
    PLATINUM("Platinum"),
    MICRO_SILVER_FUTURES("Micro%20Silver%20Futures"),
    LEAN_HOGS_FUTURES("Lean%20Hogs%20Futures"),
    CORN_FUTURES("Corn%20Futures"),
    OAT_FUTURES("Oat%20Futures"),
    ALUMINUM_FUTURES("Aluminum%20Futures"),
    SOYBEAN_MEAL_FUTURES("Soybean%20Meal%20Futures"),
    SILVER_FUTURES("Silver%20Futures"),
    SOYBEAN_FUTURES("Soybean%20Futures"),
    LUMBER_FUTURES("Lumber%20Futures"),
    LIVE_CATTLE_FUTURES("Live%20Cattle%20Futures"),
    SUGAR("Sugar"),
    NATURAL_GAS("Natural%20Gas"),
    CRUDE_OIL("Crude%20Oil"),
    ORANGE_JUICE("Orange%20Juice"),
    COFFEE("Coffee"),
    COTTON("Cotton"),
    COPPER("Copper"),
    MICRO_GOLD_FUTURES("Micro%20Gold%20Futures"),
    FEEDER_CATTLE_FUTURES("Feeder%20Cattle%20Futures"),
    ROUGH_RICE_FUTURES("Rough%20Rice%20Futures"),
    PALLADIUM("Palladium"),
    COCOA("Cocoa"),
    BRENT_CRUDE_OIL("Brent%20Crude%20Oil"),
    GASOLINE_RBOB("Gasoline%20RBOB"),
    HEATING_OIL("Heating%20Oil"),
    CLASS_III_MILK_FUTURES("Class%20III%20Milk%20Futures");

    private final String parameter;

    eCommodities(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
