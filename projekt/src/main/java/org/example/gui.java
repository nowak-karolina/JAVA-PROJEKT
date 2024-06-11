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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        updateChartData(comboBoxCommodity.getSelectedItem().toString());


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
                //String parameter = eCommodity.getValueOf(comboBoxCommodity.getSelectedItem().toString());
                //Commodity commodity = apiConnection.getJson(parameter);
                //sqlConnection.addToDB(commodity);
                updateChartData(comboBoxCommodity.getSelectedItem().toString());
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
                "Time",
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
            dataset.removeAllSeries();
            jPanelChart.repaint();
            return;
        }
        TimeSeries timeSeries = new TimeSeries(param);
        for (Commodity commodity : commodities) {
            String timestampStr = commodity.timestamp;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date parsedDate = dateFormat.parse(timestampStr);
                long timestampMillis = parsedDate.getTime();
                Timestamp timestamp = new Timestamp(timestampMillis);
                //System.out.println(timestamp.toString());
                timeSeries.addOrUpdate(new Second(timestamp), commodity.price);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        dataset.removeAllSeries();
        dataset.addSeries(timeSeries);

        jPanelChart.repaint();
    }
}
