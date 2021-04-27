import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.Map;

public class Response {
    private JSONParser parser = new JSONParser();

    private JSONObject json;


    public Response(ClassicHttpResponse response) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String jsonString = EntityUtils.toString(response.getEntity());
        this.json = (JSONObject) parser.parse(jsonString);
    }

    public Response() {
    }

    public void input(String jsonString) throws org.json.simple.parser.ParseException {
        this.json = (JSONObject) parser.parse(jsonString);
    }

    public String getTicker(){
        Map data = (Map) json.get("quotes");
        Map quotes = (Map) data.get("quote");

        return quotes.get("symbol").toString();
    }

    public String getPrice(){
        Map data = (Map) json.get("quotes");
        Map quotes = (Map) data.get("quote");

        return quotes.get("last").toString();
    }

    @Override
    public String toString() {
        return json.toString();
    }
}
