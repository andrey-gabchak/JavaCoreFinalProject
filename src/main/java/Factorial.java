import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by coura on 10.04.2016.
 *
 * Search of factorial of entered number.
 */

public class Factorial {

    public BigInteger searchOfFactorial(int number){
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= number; ++i) factorial = factorial.multiply(BigInteger.valueOf(i));
            return factorial;
    }

}
