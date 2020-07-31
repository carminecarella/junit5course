import airplane.Airplane;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
public class AirplaneTest {

    //SUT (System Under Test)
    private Airplane airplane;

    // test fixture
    @BeforeAll
    static void setupAll() {
        System.out.println("this method is executed before all @Test methods");
    }

    @BeforeEach
    void setup() {
        System.out.println("this method is executed before each @Test method");
        airplane = new Airplane();
    }

    // teardown
    @AfterAll
    static void teardownAll() {
        System.out.println("this method is executed after all @Test methods");
    }

    @AfterEach
    void teardown() {
        System.out.println("this method is executed after each @Test method");
    }

    // No public modifier is required
    @Test
    @DisplayName("Should return commercial flight")
    void shouldReturnCommercialFlight() {
        airplane.setModel("Boing");

        //exercise SUT
        String result  = airplane.getType();

        //verify
        assertEquals("Commercial", result);

        assertTrue(result.startsWith("C"));
        assertFalse(result.isEmpty());

        assertAll("Flights",
                () -> assertFalse(result.isEmpty()),
                () -> assertEquals("Commercial", result)
        );
    }

}
