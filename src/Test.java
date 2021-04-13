// Version 1.8.0_31
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.ClassicHttpRequests;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;



import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        final ClassicHttpRequest request = ClassicRequestBuilder
                .get("https://sandbox.tradier.com/v1/markets/quotes")
                .addHeader("Authorization", "Bearer 3CAzLDsTjs2M3pqMhv7INikBPJnp")
                .addHeader("Accept", "application/json")
                .addParameter("symbols", "AAPL,VXX190517P00016000")
                .build();
        final ClassicHttpResponse response = HttpClientBuilder.create().build().execute(request);
        final String jsonString = EntityUtils.toString(response.getEntity());
        final JsonNode json = new ObjectMapper().readTree(jsonString);

        System.out.println(response.getCode());
        System.out.println(json);
    }
}
