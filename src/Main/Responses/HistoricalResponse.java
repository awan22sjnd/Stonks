package Main.Responses;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.Map;

public class HistoricalResponse {
    private final JSONParser parser = new JSONParser();
    private JSONObject json;
    private Map map;
    private JSONArray dayArray;

    public HistoricalResponse(){

    }

    public HistoricalResponse(String jsonString) throws org.json.simple.parser.ParseException {
        json = (JSONObject) parser.parse(jsonString);
    }

    public HistoricalResponse(ClassicHttpResponse response) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String jsonString = EntityUtils.toString(response.getEntity());
        json = (JSONObject) parser.parse(jsonString);
        map = (Map) json.get("history");
        dayArray = (JSONArray) map.get("day");
    }

    public void setResponse(ClassicHttpResponse response) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String jsonString = EntityUtils.toString(response.getEntity());
        this.json = (JSONObject) parser.parse(jsonString);
        map = (Map) json.get("history");
        dayArray = (JSONArray) map.get("day");
    }

    public JSONArray getArray() {
        return dayArray;
    }

    public XYDataset createPriceDataset() {
        TimeSeries series = new TimeSeries("Price");
        String[] data;
        for (int x = 0; x < dayArray.size(); x++) {
            Map map = (Map) dayArray.get(x);
            data = map.get("date").toString().split("-");
            series.add(new Day(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])), (double) map.get("close"));
        }
        return new TimeSeriesCollection(series);

    }

    public JFreeChart createChart(String title) {
        TimeSeries series = new TimeSeries("Price");
        String[] data;
        for (int x = 0; x < dayArray.size(); x++) {
            Map map = (Map) dayArray.get(x);
            data = map.get("date").toString().split("-");
            series.add(new Day(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])), (double) map.get("close"));
        }
        XYDataset priceData = new TimeSeriesCollection(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                title,
                "Date",
                "Price",
                priceData,
                true,
                true,
                false
        );
        return chart;
    }

    @Override
    public String toString() {
        return dayArray.toString();
    }
}
