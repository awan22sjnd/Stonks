import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException, ParseException {
	    UserInterface ui = new UserInterface();
	    Request request = new Request();
	    Response response;
        standard(ui,request);
	    response = request.getData();
	    displayData(ui,response);
    }

    public static void standard(UserInterface ui, Request req){
        String ticker = ui.input();
        req.setTicker(ticker);
    }

    public static void displayData(UserInterface ui, Response res){
        ui.displayData(res);
    }
}
