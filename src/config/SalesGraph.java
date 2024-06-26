package config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class SalesGraph {
    private static final Logger LOGGER = Logger.getLogger(SalesGraph.class.getName());

    public static ChartPanel createGraph() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dbConnector connect = new dbConnector();

        String query = "SELECT DATE(t_datetime) AS transaction_date, SUM(t_total) AS total_sales " +
                       "FROM transactions " +
                       "WHERE t_datetime >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) " +
                       "GROUP BY DATE(t_datetime)";

        ResultSet rs = null;
        
        try {
            rs = connect.getData(query);
            if (rs == null) {
                LOGGER.log(Level.WARNING, "ResultSet is null, check the database connection and query.");
                return createEmptyChartPanel();
            }

            boolean hasData = false;
            while (rs.next()) {
                String transactionDate = rs.getString("transaction_date");
                double totalSales = rs.getDouble("total_sales");
                dataset.addValue(totalSales, "Sales", transactionDate);
                hasData = true;
            }
            
            if (!hasData) {
                LOGGER.log(Level.INFO, "No sales data found for the last 7 days.");
                return createEmptyChartPanel();
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "SQL Exception occurred", ex);
            return createEmptyChartPanel();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Failed to close ResultSet", ex);
                }
            }
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Sales",    // chart title
            "Date",     // domain axis label
            "Amount",   // range axis label
            dataset     // data
        );

        return new ChartPanel(chart);
    }

    private static ChartPanel createEmptyChartPanel() {
        DefaultCategoryDataset emptyDataset = new DefaultCategoryDataset();
        emptyDataset.addValue(0, "Sales", "No Data");

        JFreeChart emptyChart = ChartFactory.createLineChart(
            "Sales",    // chart title
            "Date",     // domain axis label
            "Amount",   // range axis label
            emptyDataset   // data
        );

        return new ChartPanel(emptyChart);
    }
}
