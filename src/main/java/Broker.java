import okhttp3.OkHttpClient;
import pwds.ApiPwd;
import v2.ApiV2;

public class Broker {

    public final ApiV2 v2;
    public final ApiPwd pwds;
    private final String DefaultUserAgent = "PwndFace";

    public Broker() {
        this(new OkHttpClient());
    }

    public Broker(OkHttpClient client) {
        OkHttpClient enhancedClient = client.newBuilder()
                .addInterceptor(new UserAgentInterceptor(DefaultUserAgent)).build();
        v2 = new ApiV2(enhancedClient);
        pwds = new ApiPwd(enhancedClient);
    }
}
