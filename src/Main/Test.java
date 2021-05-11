package Main;// Version 1.8.0_31

import Main.Requests.HistoricalRequest;
import Main.Requests.RealtimeRequest;
import Main.Responses.HistoricalResponse;
import Main.Responses.RealtimeResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.jfree.data.time.Day;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.Map;

public class Test {
    private static final String KEY = "Bearer 3CAzLDsTjs2M3pqMhv7INikBPJnp";

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        //Main.UserInterface ui = new Main.UserInterface();
        //ui.launch();
        //TestCode.Simple simple = new TestCode.Simple();
        //JFrame f = new JFrame();//creating instance of JFrame
        //test();
        optionTest();
    }

    public static void optionTest() throws IOException, ParseException {
        final ClassicHttpRequest request = ClassicRequestBuilder
                .get("https://sandbox.tradier.com/v1/markets/options/chains")
                .addHeader("Authorization", KEY)
                .addHeader("Accept", "application/json")
                .addParameter("symbol", "AMD")
                .addParameter("expiration", "2021-05-21")
                .addParameter("greeks", "true")
                .build();
        final ClassicHttpResponse response = HttpClientBuilder.create().build().execute(request);
        final String jsonString = EntityUtils.toString(response.getEntity());
        final JsonNode json = new ObjectMapper().readTree(jsonString);
        System.out.println(json);

    }

    public static void test() throws IOException, ParseException, org.json.simple.parser.ParseException {
        RealtimeRequest ds = new RealtimeRequest();
        ds.setKEY(KEY);
        ds.setTicker("AMD");
        RealtimeResponse response = ds.getData();

        System.out.println(response);
        System.out.println(response.getPrice());
        System.out.println(response.getTicker());
        HistoricalRequest ab = new HistoricalRequest();
        ab.setKEY(KEY);
        ab.setTicker("AMD");
        HistoricalResponse hresponse = ab.getData();
        System.out.println(hresponse);
        JSONArray array = hresponse.getArray();
        for (int x = 0; x < array.size(); x++) {
            Map map = (Map) array.get(x);
            String temp = (String) map.get("date");
            //System.out.println(temp);
            String[] data = temp.split("-");
            for (int p = 0; p < array.size(); p++) {
                Map pam = (Map) array.get(p);
                data = pam.get("date").toString().split("-");
                System.out.println(new Day(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])));
            }
            System.out.println();

        }

    }
}
