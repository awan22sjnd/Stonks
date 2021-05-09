package Main.Responses;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.Map;

public class RealtimeResponse {
    private JSONParser parser = new JSONParser();
    private JSONObject json;
    private Map map;


    public void setResponse(ClassicHttpResponse response) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String jsonString = EntityUtils.toString(response.getEntity());
        this.json = (JSONObject) parser.parse(jsonString);
        map = (Map) json.get("quotes");
        map = (Map) map.get("quote");
    }

    public String getTicker() {
        return map.get("symbol").toString();
    }

    public String getPrice() {
        return map.get("last").toString();
    }

    public String toString() {
        return json.toString();
    }

}