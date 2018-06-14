import org.junit.jupiter.api.AfterEach;

public abstract class AbstractTestSetup {
    protected final Broker broker = new Broker();

    @AfterEach
    public void rateLimitHandler() throws InterruptedException {
        Thread.sleep(1500);
    }
}
