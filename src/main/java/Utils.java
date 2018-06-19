import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import okhttp3.Response;

import java.io.IOException;

public class Utils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode parseResponse(Response response) throws IOException {
        return mapper.readTree(response.body().string());
    }

    public static String sha1(String password) {
        return Hashing.sha1().hashString(password,  Charsets.UTF_8).toString();
    }
}
