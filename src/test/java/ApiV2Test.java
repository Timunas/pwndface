import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiV2Test extends AbstractTestSetup {

    @Test
    public void getBreach() throws IOException {
        Response response = broker.v2.getBreach("Adobe");
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }

    @Test
    public void getBreaches() throws IOException {
        Response response = broker.v2.getBreaches();
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }

    @Test
    public void getBreachesWithDomainFilter() throws IOException {
        Response response = broker.v2.getBreaches("000webhost.com");
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }

    @Test
    public void getAccountBreaches() throws IOException {
        Response response = broker.v2.getAccountBreaches("test@hotmail.com");
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }

    @Test
    public void getAccountBreachesComplex() throws IOException {
        Response response = broker.v2.getAccountBreaches("test@hotmail.com", "000webhost.com", true, true);
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }

    @Test
    public void getDataClasses() throws IOException {
        Response response = broker.v2.getDataClasses();
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }

    @Test
    public void getPastes() throws IOException {
        Response response = broker.v2.getPastes("test@example.com");
        assertThat(response).isNotNull();

        JsonNode parsedResponse = Utils.parseResponse(response);

        assertThat(parsedResponse).isNotNull();
        assertThat(parsedResponse.toString()).isNotEmpty();
    }
}
