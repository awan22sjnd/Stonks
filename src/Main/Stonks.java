package Main;

import Main.Requests.HistoricalRequest;
import Main.Requests.RealtimeRequest;
import Main.Requests.ResponseGenerator;
import Main.Responses.HistoricalResponse;
import Main.Responses.RealtimeResponse;
import org.apache.hc.core5.http.ParseException;

import javax.swing.*;
import java.io.IOException;

public class Stonks {

    private final UserInterface ui;
    private final RealtimeRequest realtimeRequest;
    private final RealtimeResponse realtimeResponse;
    private final HistoricalRequest historicalRequest;
    private final HistoricalResponse historicalResponse;

    private final ResponseGenerator generator;

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Stonks app = new Stonks();
        app.run();
    }


    public Stonks() throws IOException, ParseException, org.json.simple.parser.ParseException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        generator = new ResponseGenerator();
        ui = new UserInterface(generator);
        realtimeRequest = new RealtimeRequest();
        realtimeResponse = new RealtimeResponse();
        historicalRequest = new HistoricalRequest();
        historicalResponse = new HistoricalResponse();
    }

    public void run() {
        ui.setHistoricalRequest(historicalRequest);
        ui.setHistoricalResponse(historicalResponse);
        ui.setRealtimeRequest(realtimeRequest);
        ui.setRealtimeResponse(realtimeResponse);
        ui.launch();
    }


    public UserInterface returnUI() {
        return ui;
    }

    public ResponseGenerator getGenerator() {
        return generator;
    }

}
