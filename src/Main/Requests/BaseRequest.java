package Main.Requests;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;

public class BaseRequest {

    public static String KEY;

    public static String ticker;

    public ClassicHttpRequest crequest;
    public ClassicHttpResponse cresponse;

    public static void setKEY(String KEY) {
        BaseRequest.KEY = KEY;
    }

    public static void setTicker(String ticker) {
        BaseRequest.ticker = ticker;
    }


}
