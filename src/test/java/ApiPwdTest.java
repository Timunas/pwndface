import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApiPwdTest extends AbstractTestSetup {

    @Test
    public void validatesPrefixLength() {
        assertThatThrownBy(() -> broker.pwds.getHashes("21BD15"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hash prefix must have 5 characters");
        assertThatThrownBy(() -> broker.pwds.getHashes("21B"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hash prefix must have 5 characters");
    }

    @Test
    public void validatesNullArgument() {
        assertThatThrownBy(() -> broker.pwds.getHashes(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Hash prefix must not be null!");
    }

    @Test
    public void getHashes() throws IOException {
        Response response = broker.pwds.getHashes(Utils.sha1("123456").substring(0, 5));

        assertThat(response).isNotNull();
        assertThat(response.body().string()).isNotEmpty();
    }
}
