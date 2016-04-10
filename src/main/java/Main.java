import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by coura on 10.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        NumbersFibonacci fib = new NumbersFibonacci();
        ArrayList<Integer> fibNumbers = fib.numericalSeriesFibonacci(n);
        fib.printFibonacci(fibNumbers);

//        System.out.println(fib.maxNumberFibonacci(n));
    }

}
