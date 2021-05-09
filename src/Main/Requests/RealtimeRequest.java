package Main.Requests;

import Main.Responses.RealtimeResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class RealtimeRequest extends BaseRequest {


    public RealtimeResponse getData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        this.crequest = ClassicRequestBuilder
                .get("https://sandbox.tradier.com/v1/markets/quotes")
                .addHeader("Authorization", KEY)
                .addHeader("Accept", "application/json")
                .addParameter("symbols", ticker)
                .addParameter("greeks", "false")
                .build();
        this.cresponse = HttpClientBuilder.create().build().execute(crequest);
        RealtimeResponse data = new RealtimeResponse();
        data.setResponse(cresponse);
        return data;
    }
}
