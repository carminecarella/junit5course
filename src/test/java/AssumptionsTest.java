import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Tag("assumptions")
public class AssumptionsTest {

    // this test is skipped because the assumption is not met
    @Test
    void assumeTrueTest() {
        assumeTrue(false);
        fail("Test 1 failed");
    }

    // this test is skipped because the assumption is not met
    @Test
    void assumeFalseTest() {
        assumeFalse(this::getTrue);
        fail("Test 2 failed");
    }

    // only () -> fail("Test 3 failed") is not executed but the test is not skipped
    @Test
    void assumeThatTest() {
        assumingThat(false, () -> fail("Test 3 failed"));
    }

    private boolean getTrue() {
        return true;
    }

}
