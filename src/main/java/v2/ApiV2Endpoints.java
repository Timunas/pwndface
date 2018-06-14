package v2;

import okhttp3.Response;

import java.io.IOException;

public interface ApiV2Endpoints {

    Response getBreaches() throws IOException;

    Response getBreaches(String domain) throws IOException;

    Response getAccountBreaches(String account) throws IOException;

    Response getAccountBreaches(String account, String domain, boolean truncate, boolean unverified) throws IOException;
}
