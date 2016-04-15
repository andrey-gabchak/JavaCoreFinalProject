import java.util.ArrayList;

/**
 * Created by coura on 10.04.2016.
 * <p>
 * Search of numerical series and max number Fibonacci.
 */

public class Fibonacci {

    public ArrayList<Integer> numericalSeriesFibonacci(int maxNumber) {

        if (maxNumber == 0) return null;

        ArrayList<Integer> numSeriesFibonacci = new ArrayList<Integer>();

        if (maxNumber == 1) {
            numSeriesFibonacci.add(1);
            return numSeriesFibonacci;
        }

        for (int i = 0; i < maxNumber; i++) {
            if (i < 2) numSeriesFibonacci.add(i, 1);
            if ((i >= 2) && ((numSeriesFibonacci.get(i - 1) + numSeriesFibonacci.get(i - 2)) <= maxNumber)) {
                numSeriesFibonacci.add(i, numSeriesFibonacci.get(i - 1) + numSeriesFibonacci.get(i - 2));
            }
            if ((i >= 2) && ((numSeriesFibonacci.get(i - 1) + numSeriesFibonacci.get(i - 2)) > maxNumber)) {
                break;
            }
        }
        return numSeriesFibonacci;
    }

    public int maxNumberFibonacci(int maxNumber) {

        if (maxNumber == 0) return 0;
        if (maxNumber == 1) return 1;
        int early = 1;
        int previos = 1;
        int maxFibonacci = 0;

        for (int i = 1; i < maxNumber; i++) {
            if ((maxFibonacci + early) <= maxNumber) {
                maxFibonacci = previos + early;
                early = previos;
                previos = maxFibonacci;
            } else break;
        }

        return maxFibonacci;
    }

    public String fibNumSeriesToString(ArrayList fibonacciNS) {
        StringBuilder fib = new StringBuilder();

        for (Object element : fibonacciNS) {
            fib.append(element);
            fib.append(", ");
        }
        fib.deleteCharAt(fib.length() - 1);
        fib.deleteCharAt(fib.length() - 1);

        String result = String.valueOf(fib);
        return result;
    }
}
