import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by coura on 11.04.2016.
 *
 * swing
 */
public class Window extends JFrame {

    private JCheckBox numberSeriesFibinacciCheckBox;
    private JCheckBox maxNumberOfFibonacciCheckBox;
    private JCheckBox factorialCheckBox;
    private JLabel descriptionField;
    private JButton findButton;
    private JTextField enteredNumerTextField;
    private JLabel resultLabel;

    public Window() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setTitle("Фибоначчи и факториал");

        descriptionField = new JLabel("Программа вычисления следующих параметров для введенного числа.");
        numberSeriesFibinacciCheckBox = new JCheckBox("Рассчитать ряд Фибоначчи к введенному числу");
        maxNumberOfFibonacciCheckBox = new JCheckBox("Рассчитать число Фибоначчи максимально приближенно у введенному");
        factorialCheckBox = new JCheckBox("Найти факториал числа");
        enteredNumerTextField = new JTextField("Введите число");
        findButton = new JButton("Рассчитать!");
        resultLabel = new JLabel();

        add(descriptionField,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(numberSeriesFibinacciCheckBox,
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 3), 0, 0));
        add(maxNumberOfFibonacciCheckBox,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(factorialCheckBox,
                new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(enteredNumerTextField,
                new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(7, 5, 5, 3), 0, 0));
        add(findButton,
                new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(12, 5, 5, 3), 0, 0));
        add(resultLabel,
                new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(12, 5, 5, 3), 0, 0));

        findButton.addActionListener(new findButtonActionListener());

        setVisible(true);
        pack();
    }

    public class findButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int number = Integer.parseInt(enteredNumerTextField.getText());
            Fibonacci fibonacci = new Fibonacci();
            if (numberSeriesFibinacciCheckBox.isSelected()) {
                ArrayList<Integer> fibonacciNumericalSeries = fibonacci.numericalSeriesFibonacci(number);
                resultLabel.setText(fibonacci.fibNumSeriesToString(fibonacciNumericalSeries));
            } else if (maxNumberOfFibonacciCheckBox.isSelected()) {
                resultLabel.setText(String.valueOf(fibonacci.maxNumberFibonacci(number)));
            } else if (factorialCheckBox.isSelected()) {
                Factorial factorial = new Factorial();
                resultLabel.setText(String.valueOf(factorial.searchOfFactorial(number)));
            }
        }
    }
}
