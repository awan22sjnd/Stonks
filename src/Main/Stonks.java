package Main;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class Stonks {

    private UserInterface ui;
    private Request request;
    private Response response;
    public static void main(String args[]){
        Stonks app = new Stonks();
        app.run();
    }


    public Stonks(){
        ui = new UserInterface(this);
        request = new Request();

    }

    public void run(){
        ui.launch();
    }


    public UserInterface returnUI(){
        return ui;
    }

    public void getData(String ticker) throws IOException, ParseException, org.json.simple.parser.ParseException {
        response = request.setTicker(ticker).setType("live").getData();
    }

    public String getTicker() {
        return response.getTicker();
    }

    public String getPrice() {
        return response.getPrice();
    }

    //Test if the key works
    public static boolean valid(String KEY){
        return true;
    }
}
