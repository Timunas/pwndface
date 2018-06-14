import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;

public class Utils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode parseResponse(Response response) throws IOException {
        return mapper.readTree(response.body().string());
    }
}
