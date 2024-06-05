import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "DevOps");

    @Test
    void testAsserts() {
        assertTrue(todos.contains("AWS"));
        assertFalse(todos.contains("GCP"));
        assertArrayEquals(new int[] {1, 2}, new int[] {1, 2});
        assertEquals(2, todos.size());
        //assertNull,assertNotNull
    }

}
