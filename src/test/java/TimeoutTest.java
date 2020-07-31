import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Tag("timeout")
public class TimeoutTest {

    @Test
    @DisplayName("Timeout test not exceeded")
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(2), () -> {
            //it takes less than 2 minutes
        });
    }

    @Disabled
    @Test
    @DisplayName("Timeout test exceeded")
    void timeoutExceeded() {
        // the expected operation should take up to 10ms
        assertTimeout(Duration.ofMillis(10), () -> {
            //Simulate a task that takes more than 10ms
            Thread.sleep(100);
        });
    }

    @Disabled("this test is skipped")
    @Test
    @DisplayName("Timeout test Preemptively")
    void timeoutPreemptively() {
        // the expected operation should take up to 10ms and preemptively means we are not waiting
        // until the end of the operation
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            //Simulate a task that takes more than 10ms
            Thread.sleep(100);
        });
    }

    @Test
    @DisplayName("Timeout test with result")
    void timeoutWithResult() {
        String actualString = assertTimeout(Duration.ofMinutes(2), () -> {
            return "result";
        });
        assertEquals("result", actualString);
    }

    @Test
    @DisplayName("Timeout test with method")
    void timeoutWithMethod() {
        String result =
                assertTimeout(Duration.ofMinutes(2), TimeoutTest::greeting);

        assertEquals("hello", result);
    }

    private static String greeting() {
        return "hello";
    }

}
