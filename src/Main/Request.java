package Main;

import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class Request {
    private String URL;
    private String KEY;

    private String ticker;
    private String type;

    private ClassicHttpRequest crequest;
    private ClassicHttpResponse cresponse;

    public Request() {
        KEY = "Bearer 3CAzLDsTjs2M3pqMhv7INikBPJnp";
    }

    public Request(String KEY) {
        this.KEY = KEY;
    }

    public Response getData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        this.crequest = ClassicRequestBuilder
                .get(URL)
                .addHeader("Authorization", KEY)
                .addHeader("Accept", "application/json")
                .addParameter("symbols", ticker)
                .addParameter("greeks", "false")
                .build();
        this.cresponse = HttpClientBuilder.create().build().execute(crequest);
        Response data = new Response(cresponse);
        return data;
    }

    public Request setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public Request setType(String type) {
        switch (type) {
            case "live":
                URL = "https://sandbox.tradier.com/v1/markets/quotes";
                break;
            case "history":
                URL = "https://sandbox.tradier.com/v1/markets/history";
                break;
        }
        return this;
    }

    public String validateStock() {
        if (ticker.length() > 5) {
            return "Ticker Length";
        }
        return "Valid";
    }
}
