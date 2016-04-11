import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by coura on 10.04.2016.
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Fibonacci fib = new Fibonacci();
        ArrayList<Integer> fibNumbers = fib.numericalSeriesFibonacci(n);
        fib.printSeriesFibonacci(fibNumbers);

        System.out.println("Максимальное число Фибоначчи: " + fib.maxNumberFibonacci(n));
    }

}
