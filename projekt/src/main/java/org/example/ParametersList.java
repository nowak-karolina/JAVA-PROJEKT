package org.example;

import com.mysql.cj.conf.ConnectionUrlParser;

import java.util.ArrayList;
import java.util.List;

public class ParametersList {
    public static List<ConnectionUrlParser.Pair<String, String>> parameters;

    public ParametersList() {
        parameters = new ArrayList<>();
        parameters.add(new ConnectionUrlParser.Pair<>("Gold Futures", "Gold%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Soybean Oil Futures", "Soybean%20Oil%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Wheat Futures", "Wheat%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Platinum", "Platinum"));
        parameters.add(new ConnectionUrlParser.Pair<>("Micro Silver Futures", "Micro%20Silver%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Lean Hogs Futures", "Lean%20Hogs%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Corn Futures", "Corn%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Oat Futures", "Oat%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Aluminum Futures", "Aluminum%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Soybean Meal Futures", "Soybean%20Meal%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Silver Futures", "Silver%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Soybean Futures", "Soybean%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Lumber Futures", "Lumber%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Live Cattle Futures", "Live%20Cattle%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Sugar", "Sugar"));
        parameters.add(new ConnectionUrlParser.Pair<>("Natural Gas", "Natural%20Gas"));
        parameters.add(new ConnectionUrlParser.Pair<>("Crude Oil", "Crude%20Oil"));
        parameters.add(new ConnectionUrlParser.Pair<>("Orange Juice", "Orange%20Juice"));
        parameters.add(new ConnectionUrlParser.Pair<>("Coffee", "Coffee"));
        parameters.add(new ConnectionUrlParser.Pair<>("Cotton", "Cotton"));
        parameters.add(new ConnectionUrlParser.Pair<>("Copper", "Copper"));
        parameters.add(new ConnectionUrlParser.Pair<>("Micro Gold Futures", "Micro%20Gold%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Feeder Cattle Futures", "Feeder%20Cattle%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Rough Rice Futures", "Rough%20Rice%20Futures"));
        parameters.add(new ConnectionUrlParser.Pair<>("Palladium", "Palladium"));
        parameters.add(new ConnectionUrlParser.Pair<>("Cocoa", "Cocoa"));
        parameters.add(new ConnectionUrlParser.Pair<>("Brent Crude Oil", "Brent%20Crude%20Oil"));
        parameters.add(new ConnectionUrlParser.Pair<>("Gasoline RBOB", "Gasoline%20RBOB"));
        parameters.add(new ConnectionUrlParser.Pair<>("Heating Oil", "Heating%20Oil"));
        parameters.add(new ConnectionUrlParser.Pair<>("Class III Milk Futures", "Class%20III%20Milk%20Futures"));
    }
}
