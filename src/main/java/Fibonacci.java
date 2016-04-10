import java.util.ArrayList;

/**
 * Created by coura on 10.04.2016.
 */
public class Fibonacci {

    public ArrayList<Integer> numericalSeriesFibonacci(int maxNumber){

        if (maxNumber == 0) return null;

        ArrayList<Integer> numSeriesFibonacci = new ArrayList<Integer>();
        if (maxNumber == 1) numSeriesFibonacci.add(1);

        for (int i = 1; i < maxNumber; i++) {

            if (numSeriesFibonacci.get(i) >= maxNumber){
                numSeriesFibonacci.remove(numSeriesFibonacci.get(i));
                break;
            } else {
                numSeriesFibonacci.add(i, numSeriesFibonacci.get(i - 1) + numSeriesFibonacci.get(i - 2));
            }
        }
        return numSeriesFibonacci;
    }
    public int maxNumberFibonacci(int maxNumber){

        if (maxNumber == 0) return 0;
        if (maxNumber == 1) return 1;
        int early = 1;
        int previos = 1;
        int maxFibonacci = 0;

        for (int i = 1; i < maxNumber; i++) {
            if ((maxFibonacci + early) <= maxNumber){
                maxFibonacci = previos + early;
                early = previos;
                previos = maxFibonacci;
            } else break;
        }

        return maxFibonacci;
    }

    public void printFibonacci(ArrayList<Integer> fib){

        for (Integer integer : fib) {
            System.out.print(integer + " ");
        }
    }
}
