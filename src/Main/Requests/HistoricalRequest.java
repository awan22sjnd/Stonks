package Main.Requests;

import Main.Responses.HistoricalResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class HistoricalRequest extends BaseRequest {

    public HistoricalResponse res;

    public HistoricalRequest(){
        res = new HistoricalResponse();
    }

    public HistoricalResponse getData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        this.crequest = ClassicRequestBuilder
                .get("https://sandbox.tradier.com/v1/markets/history")
                .addHeader("Authorization", KEY)
                .addHeader("Accept", "application/json")
                .addParameter("symbol", ticker)
                .build();
        this.cresponse = HttpClientBuilder.create().build().execute(crequest);
        res.setResponse(cresponse);
        return res;
    }
}
