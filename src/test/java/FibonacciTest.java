import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import java.util.ArrayList;

/**
 * Created by coura on 11.04.2016.
 */

public class FibonacciTest {

    private static Fibonacci numbersFibonacci;

    @BeforeClass
    public static void setUpClass() throws Exception {
        numbersFibonacci = new Fibonacci();
    }

    @Test
    public void testNumericalSeriesFibonacciNull() {
        int maxNumber = 0;

        ArrayList<Integer> result = numbersFibonacci.numericalSeriesFibonacci(maxNumber);

        Assert.assertEquals(null, result);
    }

    @Test
    public void testNumericalSeriesFibonacciMinValue() {
        int maxNumber = 1;

        ArrayList<Integer> result = numbersFibonacci.numericalSeriesFibonacci(maxNumber);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumericalSeriesFibonacciMaxValue() {
        int maxNumber = 100;

        ArrayList<Integer> result = numbersFibonacci.numericalSeriesFibonacci(maxNumber);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(8);
        expected.add(13);
        expected.add(21);
        expected.add(34);
        expected.add(55);
        expected.add(89);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNumericalSeriesFibonacciMaxValueIsMaxFibonacci() {
        int maxNumber = 89;

        ArrayList<Integer> result = numbersFibonacci.numericalSeriesFibonacci(maxNumber);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(8);
        expected.add(13);
        expected.add(21);
        expected.add(34);
        expected.add(55);
        expected.add(89);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMaxNumberFibonacciMinValue() {
        int maxNumber = 1;

        int result = numbersFibonacci.maxNumberFibonacci(maxNumber);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testMaxNumberFibonacciMaxValue() {
        int maxNumber = 100;

        int result = numbersFibonacci.maxNumberFibonacci(maxNumber);

        Assert.assertEquals(89, result);
    }

    @Test
    public void testMaxNumberFibonacciMaxValueIsMaxFibonacci() {
        int maxNumber = 89;

        int result = numbersFibonacci.maxNumberFibonacci(maxNumber);

        Assert.assertEquals(89, result);
    }

    @Test
    public void testMaxNumberFibonacciNull() {
        int maxNumber = 0;

        int result = numbersFibonacci.maxNumberFibonacci(maxNumber);

        Assert.assertEquals(0, result);
    }
}
