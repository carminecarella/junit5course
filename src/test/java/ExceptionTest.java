import airplane.Airplane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("exception")
public class ExceptionTest {

    private Airplane airplane;

    @BeforeEach
    void setup() {
        airplane = new Airplane();
    }

    @Test
    @DisplayName("Should return an exception")
    void shouldReturnException() {
        airplane.setModel("none");

        //verify
        Throwable ex = assertThrows(IllegalArgumentException.class,
                () -> airplane.getType()
        );

        assertEquals("Flight Type not found", ex.getMessage());
    }

}
