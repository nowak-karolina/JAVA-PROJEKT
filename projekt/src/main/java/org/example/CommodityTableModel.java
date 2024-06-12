package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CommodityTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Exchange", "Name", "Price", "Updated", "Timestamp"};
    private List<Commodity> commodities;

    public CommodityTableModel(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    @Override
    public int getRowCount() {
        return commodities.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Commodity commodity = commodities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return commodity.exchange;
            case 1:
                return commodity.name;
            case 2:
                return commodity.price;
            case 3:
                return commodity.updated;
            case 4:
                return commodity.timestamp;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
        fireTableDataChanged();
    }
}
