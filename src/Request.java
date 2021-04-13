import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class Request {
    private String ticker;
    final String URL = "https://sandbox.tradier.com/v1/markets/quotes";
    final String KEY = "Bearer 3CAzLDsTjs2M3pqMhv7INikBPJnp";
    private ClassicHttpRequest crequest;
    private ClassicHttpResponse cresponse;
    private Response res;

    public Response getData() throws IOException, ParseException {
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

    public void setTicker(String ticker){
        this.ticker = ticker;
    }
}
