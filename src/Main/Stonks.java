package Main;

import Main.Requests.HistoricalRequest;
import Main.Requests.RealtimeRequest;
import Main.Responses.HistoricalResponse;
import Main.Responses.RealtimeResponse;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class Stonks {

    private UserInterface ui;
    private RealtimeRequest realtimeRequest;
    private RealtimeResponse realtimeResponse;
    private HistoricalRequest historicalRequest;
    private HistoricalResponse historicalResponse;

    public static void main(String args[]) throws IOException, ParseException, org.json.simple.parser.ParseException {
        Stonks app = new Stonks();
        app.run();
    }


    public Stonks() throws IOException, ParseException, org.json.simple.parser.ParseException {
        ui = new UserInterface();
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

}
