import okhttp3.OkHttpClient;
import v2.ApiV2;

public class Broker {

    public final ApiV2 v2;
    private final String DefaultUserAgent = "PwndFace";

    public Broker() {
        this(new OkHttpClient());
    }

    public Broker(OkHttpClient client) {
        OkHttpClient enhancedClient = client.newBuilder()
                .addInterceptor(new UserAgentInterceptor(DefaultUserAgent)).build();
        v2 = new ApiV2(enhancedClient);
    }
}
