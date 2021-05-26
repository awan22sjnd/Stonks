package Main;

import Main.Requests.HistoricalRequest;
import Main.Requests.RealtimeRequest;
import Main.Requests.ResponseGenerator;
import Main.Responses.HistoricalResponse;
import Main.Responses.RealtimeResponse;
import Windows.Login;
import Windows.MainWindow;
import org.apache.hc.core5.http.ParseException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private JFrame frame;
    public Login login;
    public MainWindow mainWindow;
    private RealtimeRequest realtimeRequest;
    private HistoricalRequest historicalRequest;
    private RealtimeResponse realtimeResponse;
    private HistoricalResponse historicalResponse;
    private ResponseGenerator generator;


    public UserInterface(ResponseGenerator generator) throws IOException, ParseException, org.json.simple.parser.ParseException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.generator = generator;
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        reader = new Scanner(System.in);
        login = new Login(this,generator);
        mainWindow = new MainWindow(this,generator);
    }

    public void launch() {
        login.setHistoricalRequest(historicalRequest);
        login.setRealtimeRequest(realtimeRequest);
        frame = new JFrame();//creating instance of JFrame
        frame.setContentPane(login.mainPanel); //set the pane to login panel
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void changePanel(JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    public RealtimeRequest getRealtimeRequest() {
        return realtimeRequest;
    }

    public void setRealtimeRequest(RealtimeRequest realtimeRequest) {
        this.realtimeRequest = realtimeRequest;
    }

    public HistoricalRequest getHistoricalRequest() {
        return historicalRequest;
    }

    public void setHistoricalRequest(HistoricalRequest historicalRequest) {
        this.historicalRequest = historicalRequest;
    }

    public RealtimeResponse getRealtimeResponse() {
        return realtimeResponse;
    }

    public void setRealtimeResponse(RealtimeResponse realtimeResponse) {
        this.realtimeResponse = realtimeResponse;
    }

    public HistoricalResponse getHistoricalResponse() {
        return historicalResponse;
    }

    public void setHistoricalResponse(HistoricalResponse historicalResponse) {
        this.historicalResponse = historicalResponse;
    }
}