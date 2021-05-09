package Windows;

import Main.Requests.HistoricalRequest;
import Main.Requests.RealtimeRequest;
import Main.Responses.HistoricalResponse;
import Main.Responses.RealtimeResponse;
import Main.Stonks;
import Main.UserInterface;
import TestCode.PriceVolumeDemo1;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.apache.hc.core5.http.ParseException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class MainWindow {
    public JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel chartPanel;
    private JPanel graphPanel;
    private JPanel tablePanel;
    private JPanel pricingPanel;
    private JPanel searchPanel;
    private JButton tickerSearchButton;
    private JTextField tickerField;
    private JLabel tickerLabel;
    private JLabel priceLabel;
    private ChartPanel GraphChartPanel;
    private JFreeChart chart;
    private RealtimeRequest realtimeRequest;
    private RealtimeResponse realtimeResponse;
    private HistoricalRequest historicalRequest;
    private HistoricalResponse historicalResponse;
    private UserInterface userInterface;

    public MainWindow(UserInterface userInterface) throws IOException, ParseException, org.json.simple.parser.ParseException {

        $$$setupUI$$$();
        tickerSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    realtimeRequest.setTicker(tickerField.getText());
                    realtimeResponse = realtimeRequest.getData();
                    historicalRequest.setTicker(tickerField.getText());
                    historicalResponse = historicalRequest.getData();
                } catch (IOException | org.json.simple.parser.ParseException | ParseException ioException) {
                    ioException.printStackTrace();
                }
                tickerLabel.setText(realtimeResponse.getTicker());
                priceLabel.setText(realtimeResponse.getPrice());
                GraphChartPanel.setChart(historicalResponse.createChart());
            }
        });

    }

    public void setRealtimeRequest(RealtimeRequest realtimeRequest) {
        this.realtimeRequest = realtimeRequest;
    }

    public void setRealtimeResponse(RealtimeResponse realtimeResponse) {
        this.realtimeResponse = realtimeResponse;
    }

    public void setHistoricalRequest(HistoricalRequest historicalRequest) {
        this.historicalRequest = historicalRequest;
    }

    public void setHistoricalResponse(HistoricalResponse historicalResponse) {
        this.historicalResponse = historicalResponse;
    }

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JFrame frame = new JFrame("MainWindow");
        Stonks stonk = new Stonks();
        frame.setContentPane(stonk.returnUI().mainWindow.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        this.GraphChartPanel = new ChartPanel(new JFreeChart(new Plot() {
            @Override
            public String getPlotType() {
                return null;
            }

            @Override
            public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor, PlotState parentState, PlotRenderingInfo info) {

            }
        }));
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(infoPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        pricingPanel = new JPanel();
        pricingPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        infoPanel.add(pricingPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tickerLabel = new JLabel();
        tickerLabel.setText("Ticker");
        pricingPanel.add(tickerLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        priceLabel = new JLabel();
        priceLabel.setText("Price");
        pricingPanel.add(priceLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        infoPanel.add(searchPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tickerSearchButton = new JButton();
        tickerSearchButton.setHorizontalAlignment(0);
        tickerSearchButton.setHorizontalTextPosition(10);
        tickerSearchButton.setText("Search");
        searchPanel.add(tickerSearchButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tickerField = new JTextField();
        tickerField.setHorizontalAlignment(0);
        searchPanel.add(tickerField, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        chartPanel = new JPanel();
        chartPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(chartPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        graphPanel = new JPanel();
        graphPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        chartPanel.add(graphPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        graphPanel.add(GraphChartPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        chartPanel.add(tablePanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
