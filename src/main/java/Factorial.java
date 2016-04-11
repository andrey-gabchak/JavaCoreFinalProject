import java.util.ArrayList;

/**
 * Created by coura on 10.04.2016.
 *
 * Search of factorial of entered number.
 */

public class Factorial {

    public int searchOfFactorial(int number){

        int facrorial = 1;

        for (int i = 1; i <= number; i++) {
            facrorial *= i;
        }

        return facrorial;
    }

}
