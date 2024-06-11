package org.example;

public enum eCommodity {
    GOLD_FUTURES("Gold Futures", "Gold%20Futures"),
    SOYBEAN_OIL_FUTURES("Soybean Oil Futures", "Soybean%20Oil%20Futures"),
    WHEAT_FUTURES("Wheat Futures", "Wheat%20Futures"),
    PLATINUM("Platinum", "Platinum"),
    MICRO_SILVER_FUTURES("Micro Silver Futures", "Micro%20Silver%20Futures"),
    LEAN_HOGS_FUTURES("Lean Hogs Futures", "Lean%20Hogs%20Futures"),
    CORN_FUTURES("Corn Futures", "Corn%20Futures"),
    OAT_FUTURES("Oat Futures", "Oat%20Futures"),
    ALUMINUM_FUTURES("Aluminum Futures", "Aluminum%20Futures"),
    SOYBEAN_MEAL_FUTURES("Soybean Meal Futures", "Soybean%20Meal%20Futures"),
    SILVER_FUTURES("Silver Futures", "Silver%20Futures"),
    SOYBEAN_FUTURES("Soybean Futures", "Soybean%20Futures"),
    LUMBER_FUTURES("Lumber Futures", "Lumber%20Futures"),
    LIVE_CATTLE_FUTURES("Live Cattle Futures", "Live%20Cattle%20Futures"),
    SUGAR("Sugar", "Sugar"),
    NATURAL_GAS("Natural Gas", "Natural%20Gas"),
    CRUDE_OIL("Crude Oil", "Crude%20Oil"),
    ORANGE_JUICE("Orange Juice", "Orange%20Juice"),
    COFFEE("Coffee", "Coffee"),
    COTTON("Cotton", "Cotton"),
    COPPER("Copper", "Copper"),
    MICRO_GOLD_FUTURES("Micro Gold Futures", "Micro%20Gold%20Futures"),
    FEEDER_CATTLE_FUTURES("Feeder Cattle Futures", "Feeder%20Cattle%20Futures"),
    ROUGH_RICE_FUTURES("Rough Rice Futures", "Rough%20Rice%20Futures"),
    PALLADIUM("Palladium", "Palladium"),
    COCOA("Cocoa", "Cocoa"),
    BRENT_CRUDE_OIL("Brent Crude Oil", "Brent%20Crude%20Oil"),
    GASOLINE_RBOB("Gasoline RBOB", "Gasoline%20RBOB"),
    HEATING_OIL("Heating Oil", "Heating%20Oil"),
    CLASS_III_MILK_FUTURES("Class III Milk Futures", "Class%20III%20Milk%20Futures");

    private final String name;
    private final String value;

    eCommodity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static String getValueOf(String name) {
        for (eCommodity commodity : eCommodity.values()) {
            if (commodity.name.equals(name)) {
                return commodity.value;
            }
        }
        return null;
    }

    public static String getNameOf(String value) {
        for (eCommodity commodity : eCommodity.values()) {
            if (commodity.value.equals(value)) {
                return commodity.name;
            }
        }
        return null;
    }
}
