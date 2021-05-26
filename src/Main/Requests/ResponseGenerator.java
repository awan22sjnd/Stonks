package Main.Requests;

import Main.Responses.HistoricalResponse;
import Main.Responses.RealtimeResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class ResponseGenerator {

    public String KEY;

    public String ticker;

    public RealtimeResponse generateRealtimeResponse() throws IOException, ParseException, org.json.simple.parser.ParseException {
        return new RealtimeResponse(HttpClientBuilder.create().build().execute(ClassicRequestBuilder
                .get("https://sandbox.tradier.com/v1/markets/quotes")
                .addHeader("Authorization", KEY)
                .addHeader("Accept", "application/json")
                .addParameter("symbols", ticker)
                .addParameter("greeks", "false")
                .build()));
    }

    public HistoricalResponse generateHistoricalResponse() throws IOException, ParseException, org.json.simple.parser.ParseException {
        return new HistoricalResponse(HttpClientBuilder.create().build().execute(ClassicRequestBuilder
                .get("https://sandbox.tradier.com/v1/markets/history")
                .addHeader("Authorization", KEY)
                .addHeader("Accept", "application/json")
                .addParameter("symbol", ticker)
                .build()));
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
