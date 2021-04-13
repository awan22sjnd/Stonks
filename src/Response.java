import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class Response {
    JsonNode json;

    public Response(ClassicHttpResponse response) throws IOException, ParseException {
        String jsonString = EntityUtils.toString(response.getEntity());
        this.json = new ObjectMapper().readTree(jsonString);
    }

    public Response() {
    }

    @Override
    public String toString() {
        return json.toString();
    }
}
