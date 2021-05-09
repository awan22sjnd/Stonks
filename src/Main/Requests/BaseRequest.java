package Main.Requests;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;

public class BaseRequest {

    public String KEY;

    public String ticker;

    public ClassicHttpRequest crequest;
    public ClassicHttpResponse cresponse;

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }


}
