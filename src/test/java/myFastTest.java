import static org.junit.jupiter.api.Assertions.assertEquals;

public class myFastTest {

    @FastTest
    void testFastAnnotation() {
        assertEquals(2, 1 + 1);
    }

}
