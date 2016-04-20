import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest {
    private static Factorial factorial;

    @BeforeClass
    public static void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void testFactorialPositive(){
        final int a = 5;
        final  double result = factorial.getFactorial(a);

        Assert.assertEquals(120,result,0);
    }

    @Test(expected = UpperLimitException.class)
    public void testMaxLimitNumber() throws Exception {
        final int a = 175;
        factorial.checkInteger(a);
    }

    @Test(expected = NegativeIntegerException.class)
    public void testNegativeNumber() throws Exception {
        final int a = -1;
        factorial.checkInteger(a);
    }

}