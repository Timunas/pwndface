package v2;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public final class ApiV2 implements ApiV2Endpoints {

    private final OkHttpClient client;

    public ApiV2(OkHttpClient client) {
        this.client = client;
    }

    private Request newRequest(List<String> urlPaths, Map<String, String> queryParameters) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://haveibeenpwned.com/api/v2").newBuilder();
        urlPaths.forEach(urlBuilder::addPathSegment);
        queryParameters.forEach(urlBuilder::addQueryParameter);

        return new Request.Builder().get().url(urlBuilder.build().toString()).build();
    }

    public Response getBreach(String breachName) throws IOException {
        List<String> urlPaths = Arrays.asList("breach", breachName);

        return client.newCall(newRequest(urlPaths, new HashMap<>())).execute();
    }

    public Response getBreaches(String domain) throws IOException {
        List<String> urlPaths = Collections.singletonList("breaches");
        Map<String, String> queryParameters = new HashMap<>();
        if (domain != null && !domain.trim().isEmpty()) queryParameters.put("domain", domain);

        return client.newCall(newRequest(urlPaths, queryParameters)).execute();
    }

    public Response getBreaches() throws IOException {
        return getBreaches(null);
    }

    public Response getAccountBreaches(String account, String domain, boolean truncate, boolean unverified) throws IOException {
        List<String> urlPaths = Arrays.asList("breachedaccount", account);
        Map<String, String> queryParameters = new HashMap<>();
        if (domain != null && !domain.trim().isEmpty()) queryParameters.put("domain", domain);
        queryParameters.put("truncateResponse", String.valueOf(truncate));
        queryParameters.put("includeUnverified", String.valueOf(unverified));

        return client.newCall(newRequest(urlPaths, queryParameters)).execute();
    }

    public Response getAccountBreaches(String account) throws IOException {
        return getAccountBreaches(account, null, false, false);
    }

    public Response getDataClasses() throws IOException {
        List<String> urlPaths = Collections.singletonList("dataclasses");

        return client.newCall(newRequest(urlPaths, new HashMap<>())).execute();
    }

    public Response getPastes(String account) throws IOException {
        List<String> urlPaths = Arrays.asList("pasteaccount", account);

        return client.newCall(newRequest(urlPaths, new HashMap<>())).execute();
    }
}
