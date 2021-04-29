package Main;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        Stonks stonk = new Stonks();
	    UserInterface ui = stonk.returnUI();
	    Request request = new Request();
	    Response response = standard(ui,request);
	    ui.displayBasicData(response);
    }

    public static Response standard(UserInterface ui, Request req) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String ticker = ui.input();
        req.setTicker(ticker);
        //req.validateStock();
        return req.getData();
    }

}
