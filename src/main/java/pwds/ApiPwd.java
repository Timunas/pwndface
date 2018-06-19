package pwds;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public final class ApiPwd {

    private final OkHttpClient client;

    public ApiPwd(OkHttpClient client) {
        this.client = client;
    }

    private Request newRequest(List<String> urlPaths, Map<String, String> queryParameters) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.pwnedpasswords.com/range/").newBuilder();
        urlPaths.forEach(urlBuilder::addPathSegment);
        queryParameters.forEach(urlBuilder::addQueryParameter);

        return new Request.Builder().get().url(urlBuilder.build().toString()).build();
    }

    /**
     * Fetches all password hashes from HaveIBeenPwned that match the prefix sent in the request.
     *
     * @param hashPrefix sent to HIBP api. Must have 5 characters size.
     * @return the http response
     * @throws IOException              if fails to perform the http request.
     * @throws IllegalArgumentException if hash prefix doesn't have 5 characters.
     * @throws NullPointerException     if hash prefix is null.
     */
    public Response getHashes(String hashPrefix) throws IOException, IllegalArgumentException, NullPointerException {

        checkArgument(
                checkNotNull(hashPrefix, "Hash prefix must not be null!").length() == 5,
                "Hash prefix must have 5 characters"
        );

        List<String> urlPaths = Collections.singletonList(hashPrefix);

        return client.newCall(newRequest(urlPaths, new HashMap<>())).execute();
    }
}
