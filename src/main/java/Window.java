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
    private JTextField inputNumberTextField;
    private JLabel resultNumericalSeriesFibonacciLabel;
    private JLabel resultMaxNumberFibonacciFibLabel;
    private JLabel resultFactorialLabel;
    private JLabel errorMessageJLabel;

    public Window() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setTitle("Фибоначчи и факториал");

        JLabel descriptionField = new JLabel("<html>Программа создана для вычисления факториала," +
                "<br>числового ряда Фибоначчи, максимального числа" +
                "<br>в ряде Фибоначии, которое не больше введеного значения." +
                "<br>Чтобы начать вичисление введите значение: </html>");
        numericalSeriesFibonacciCheckBox = new JCheckBox("Ряд Фибоначчи");
        maxNumberOfFibonacciCheckBox = new JCheckBox("Максимальное число в ряду Фибоначчи");
        factorialCheckBox = new JCheckBox("Факториал");
        inputNumberTextField = new JTextField();
        JButton findButton = new JButton("Рассчитать!");
        resultNumericalSeriesFibonacciLabel = new JLabel();
        resultMaxNumberFibonacciFibLabel = new JLabel();
        resultFactorialLabel = new JLabel();

        add(descriptionField,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 3), 0, 0));
        add(inputNumberTextField,
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(7, 5, 5, 3), 0, 0));
        add(numericalSeriesFibonacciCheckBox,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 3), 0, 0));
        add(maxNumberOfFibonacciCheckBox,
                new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(factorialCheckBox,
                new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
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

        errorMessageJLabel = new JLabel();
        errorMessageJLabel.setForeground(Color.RED);
        add(errorMessageJLabel,
                new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));

        setVisible(true);
        pack();
    }

    public class findButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String inputString = inputNumberTextField.getText();
            Validation validation = new Validation();
            if ((!numericalSeriesFibonacciCheckBox.isSelected()) &&
                    (!maxNumberOfFibonacciCheckBox.isSelected()) &&
                    (!factorialCheckBox.isSelected())){
                outputErrorInput("<html>[Error] Вы ничего не ввели! " +
                        "<br>Необходимо ввести положительное целое число!<html>");
            } else if (validation.isValid(inputString)){
                int number = Integer.parseInt(inputString);
                outputResult(number);
            } else {
                outputErrorInput("[Error] Некорректный ввод! " +
                        "Необходимо ввести положительное целое число!");
            }
        }

        private void outputResult(int number) {
            Fibonacci fibonacci = new Fibonacci();
            errorMessageJLabel.setVisible(false);

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

        private void outputErrorInput(String errorText){
            errorMessageJLabel.setVisible(true);
            errorMessageJLabel.setText(errorText);
            resultFactorialLabel.setVisible(false);
            resultMaxNumberFibonacciFibLabel.setVisible(false);
            resultNumericalSeriesFibonacciLabel.setVisible(false);
        }
    }
}
