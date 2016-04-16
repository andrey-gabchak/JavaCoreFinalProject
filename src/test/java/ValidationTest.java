import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by coura on 16.04.2016.
 */

public class ValidationTest {

    private static Validation validation;

    @BeforeClass
    public static void setUpClass() throws Exception {
        validation = new Validation();

    }

    @Test
    public void testIsValidNull() throws Exception {
        String inputValue = "0";
        int result = validation.isValid(inputValue);
        assertEquals(0, result);
    }

    @Test
    public void testIsValidEmpty() throws Exception {
        String inputValue = null;
        int result = validation.isValid(inputValue);
        assertEquals(-2, result);
    }

    @Test
    public void testIsValidNegative() throws Exception {
        String inputValue = "-4";
        int result = validation.isValid(inputValue);
        assertEquals(-1, result);
    }

    @Test
    public void testIsValidIncorrectString() throws Exception {
        String inputValue = "asdf";
        int result = validation.isValid(inputValue);
        assertEquals(-2, result);
    }
    @Test
    public void testIsValidPositiveInteger() throws Exception {
        String inputValue = "4";
        int result = validation.isValid(inputValue);
        assertEquals(1, result);
    }


}