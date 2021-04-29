import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.Map;

public class Response {
    private JSONParser parser = new JSONParser();

    private JSONObject json;
    private Map mmap;
    private String[][] data;

    public Response(ClassicHttpResponse response) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String jsonString = EntityUtils.toString(response.getEntity());
        this.json = (JSONObject) parser.parse(jsonString);
        mmap = (Map) json.get("quotes");
    }

    public Response() {
    }

    public void input(String jsonString) throws org.json.simple.parser.ParseException {
        this.json = (JSONObject) parser.parse(jsonString);
    }

    public String getTicker(){
        Map quotes = (Map) mmap.get("quote");

        return quotes.get("symbol").toString();
    }

    public String getPrice(){
        Map quotes = (Map) mmap.get("quote");

        return quotes.get("last").toString();
    }

    @Override
    public String toString() {
        return json.toString();
    }

    public XYDataset createPriceDataset(){
        TimeSeries series1 = new TimeSeries("Price");

        return new TimeSeriesCollection(series1);
    }
}
