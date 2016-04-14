import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by coura on 11.04.2016.
 *
 * Implementation of the program window
 */
public class Window extends JFrame {

    private JCheckBox numericalSeriesFibonacciCheckBox;
    private JCheckBox maxNumberOfFibonacciCheckBox;
    private JCheckBox factorialCheckBox;
    private JLabel descriptionField;
    private JButton findButton;
    private JTextField inputNumberTextField;
    private JLabel resultNumericalSeriesFibonacciLabel;
    private JLabel resultMaxNumberFibonacciFibLabel;
    private JLabel resultFactorialLabel;

    public Window() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setTitle("Фибоначчи и факториал");

        descriptionField = new JLabel("Программа вычисления следующих параметров для введенного числа.");
        numericalSeriesFibonacciCheckBox = new JCheckBox("Рассчитать ряд Фибоначчи к введенному числу");
        maxNumberOfFibonacciCheckBox = new JCheckBox("Рассчитать число Фибоначчи максимально приближенно у введенному");
        factorialCheckBox = new JCheckBox("Найти факториал числа");
        inputNumberTextField = new JTextField("5");
        findButton = new JButton("Рассчитать!");
        resultNumericalSeriesFibonacciLabel = new JLabel();
        resultMaxNumberFibonacciFibLabel = new JLabel();
        resultFactorialLabel = new JLabel();

        add(descriptionField,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 3), 0, 0));
        add(numericalSeriesFibonacciCheckBox,
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 3), 0, 0));
        add(maxNumberOfFibonacciCheckBox,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(factorialCheckBox,
                new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(inputNumberTextField,
                new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(7, 5, 5, 3), 0, 0));
        add(findButton,
                new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(12, 5, 5, 3), 0, 0));
        add(resultNumericalSeriesFibonacciLabel,
                new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(12, 5, 5, 3), 0, 0));
        add(resultMaxNumberFibonacciFibLabel,
                new GridBagConstraints(0, 7, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(resultFactorialLabel,
                new GridBagConstraints(0, 8, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));

        findButton.addActionListener(new findButtonActionListener());

        setVisible(true);
        pack();
    }

    public class findButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int number = Integer.parseInt(inputNumberTextField.getText());
            outputResult(number);
        }

        private void outputResult(int number) {
            Fibonacci fibonacci = new Fibonacci();

            if (numericalSeriesFibonacciCheckBox.isSelected()) {
                ArrayList<Integer> fibonacciNumericalSeries = fibonacci.numericalSeriesFibonacci(number);
                resultNumericalSeriesFibonacciLabel.setText("Ряд Фибоначчи: "
                        + fibonacci.fibNumSeriesToString(fibonacciNumericalSeries));
                resultMaxNumberFibonacciFibLabel.setVisible(false);
                resultFactorialLabel.setVisible(false);
                resultNumericalSeriesFibonacciLabel.setVisible(true);

                if (maxNumberOfFibonacciCheckBox.isSelected()) {
                    resultMaxNumberFibonacciFibLabel.setText("Максимальное число Фибоначчи: "
                            + String.valueOf(fibonacci.maxNumberFibonacci(number)));
                    resultMaxNumberFibonacciFibLabel.setVisible(true);

                    if (factorialCheckBox.isSelected()) {
                        Factorial factorial = new Factorial();
                        resultFactorialLabel.setText("Факториал: "
                                + String.valueOf(factorial.searchOfFactorial(number)));
                        resultFactorialLabel.setVisible(true);
                    }
                }
            } else if (maxNumberOfFibonacciCheckBox.isSelected()) {
                resultMaxNumberFibonacciFibLabel.setText("Максимальное число Фибоначчи: "
                        + String.valueOf(fibonacci.maxNumberFibonacci(number)));
                resultNumericalSeriesFibonacciLabel.setVisible(false);
                resultFactorialLabel.setVisible(false);
                resultMaxNumberFibonacciFibLabel.setVisible(true);

                if (factorialCheckBox.isSelected()) {
                    Factorial factorial = new Factorial();
                    resultFactorialLabel.setText("Факториал: "
                            + String.valueOf(factorial.searchOfFactorial(number)));
                    resultFactorialLabel.setVisible(true);
                }
            } else if (factorialCheckBox.isSelected()) {
                Factorial factorial = new Factorial();
                resultFactorialLabel.setText("Факториал: "
                        + String.valueOf(factorial.searchOfFactorial(number)));
                resultNumericalSeriesFibonacciLabel.setVisible(false);
                resultMaxNumberFibonacciFibLabel.setVisible(false);
            }
        }
    }
}
