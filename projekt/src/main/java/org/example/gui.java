package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

public class gui {

    private JComboBox comboBoxCommodity;
    private JButton getMoreDataButton;
    private JPanel jPanelChart;
    private JPanel jPanelMain;

    private SQLConnection sqlConnection;
    private TimeSeriesCollection dataset;
    private ApiConnection apiConnection;


    public gui(){
        sqlConnection = new SQLConnection();
        dataset = new TimeSeriesCollection();
        apiConnection = new ApiConnection();


        for(eCommodity commodity : eCommodity.values()){
            //System.out.println(commodity);
            comboBoxCommodity.addItem(commodity.getName());
            //System.out.println(commodity.getParameter());
        }
        comboBoxCommodity.setSelectedIndex(0);


        getMoreDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sqlConnection.getData(eCommodity.getValueOf(comboBoxCommodity.getSelectedItem().toString()));
                String parameter = eCommodity.getValueOf(comboBoxCommodity.getSelectedItem().toString());
                Commodity commodity = apiConnection.getJson(parameter);
                sqlConnection.addToDB(commodity);
                updateChartData(comboBoxCommodity.getSelectedItem().toString());
            }
        });


        comboBoxCommodity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //NOWY WYKRES
            }
        });

        createChart();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new gui().jPanelMain);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);

    }

    public void createChart() {
        JFreeChart chart = ChartFactory.createTimeSeriesChart( //wykres czasowy
                "Commodity Prices",
                "Updated",
                "Price",
                dataset,
                true,
                true,
                false
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(); //wyswiatlanie linii i punktow
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart); //zrobienie wykresu i dodanie do gui
        jPanelChart.setLayout(new BorderLayout());
        jPanelChart.add(chartPanel, BorderLayout.CENTER);
        jPanelChart.validate();
    }

    private void updateChartData(String param) {
        List<Commodity> commodities = sqlConnection.getData(param);

        if (commodities.isEmpty()) {
            System.out.println("No commodities found");
            return;
        }
        TimeSeries timeSeries = new TimeSeries(param);
        for (Commodity commodity : commodities) {
            // Konwertujemy wartość 'updated' na obiekt Timestamp
            Timestamp timestamp = new Timestamp(commodity.updated);
            System.out.println(timestamp.toString());
            // Dodajemy dane do serii czasowej
            timeSeries.addOrUpdate(new Second(timestamp), commodity.price);
        }

        dataset.removeAllSeries();
        dataset.addSeries(timeSeries);

        jPanelChart.repaint();
    }
}
