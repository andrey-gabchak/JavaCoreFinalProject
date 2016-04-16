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
    private JPanel dialogJPanel;

    public Window() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setTitle("Фибоначчи и факториал");
        setResizable(false);

        JLabel descriptionField = new JLabel("<html>Программа создана для вычисления факториала," +
                "<br>числового ряда Фибоначчи, максимального числа" +
                "<br>в ряде Фибоначии, которое не больше введеного значения." +
                "<br>Введите число для расчета:</html>");
        numericalSeriesFibonacciCheckBox = new JCheckBox("Ряд Фибоначчи");
        maxNumberOfFibonacciCheckBox = new JCheckBox("Максимальное число в ряду Фибоначчи");
        factorialCheckBox = new JCheckBox("Факториал");
        inputNumberTextField = new JTextField();
        JButton findButton = new JButton("Рассчитать!");
        dialogJPanel = new JPanel();
        JPanel descriptionPanel = new JPanel();

        add(descriptionPanel);
        add(descriptionField,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 3), 0, 0));
        descriptionPanel.add(descriptionField);
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

        findButton.addActionListener(new findButtonActionListener());

        setVisible(true);
        pack();
    }

    public class findButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String inputString = inputNumberTextField.getText();
            Validation validation = new Validation();
            if ((!numericalSeriesFibonacciCheckBox.isSelected()) &&
                    (!maxNumberOfFibonacciCheckBox.isSelected()) &&
                    (!factorialCheckBox.isSelected())) {
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Вы ничего не ввели!" +
                        "<br>Для рассчета необходимо ввести " +
                        "<br>положительное целое число.<html>", "Ошибка", JOptionPane.DEFAULT_OPTION);
            } else if (validation.isValid(inputString) == 1) {
                int number = Integer.parseInt(inputString);
                outputResult(number);
            } else if (validation.isValid(inputString) == -1){
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Невозможно произвести расчет " +
                        "для отрицательного числа!" +
                        "<br>Для рассчета необходимо ввести " +
                        "положительное целое число.<html>", "Ошибка", JOptionPane.DEFAULT_OPTION);
            } else if(validation.isValid(inputString) == -2){
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Некорректный ввод!" +
                        "<br>Для рассчета необходимо ввести " +
                        "положительное целое число.<html>", "Ошибка", JOptionPane.DEFAULT_OPTION);
            } else if (validation.isValid(inputString) == 0){
                if ((!numericalSeriesFibonacciCheckBox.isSelected()) && (!maxNumberOfFibonacciCheckBox.isSelected())
                        && factorialCheckBox.isSelected()){
                    Factorial factorial = new Factorial();
                    JOptionPane.showMessageDialog(dialogJPanel, "Факториал: " +
                                    String.valueOf(factorial.searchOfFactorial(Integer.parseInt(inputString))),
                            "Результат", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showMessageDialog(dialogJPanel, "<html>Нуль!" +
                            "<br>Для значения '0' можно посчитать" +
                            "<br>только факториал.<html>", "Ошибка", JOptionPane.DEFAULT_OPTION);
                }
            }
        }

        private void outputResult(int number) {
            Fibonacci fibonacci = new Fibonacci();
            Factorial factorial = new Factorial();

            if (numericalSeriesFibonacciCheckBox.isSelected() && maxNumberOfFibonacciCheckBox.isSelected()
                    && factorialCheckBox.isSelected()){
                ArrayList<Integer> fibonacciNumericalSeries = fibonacci.numericalSeriesFibonacci(number);
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Ряд Фибоначчи: "
                        + fibonacci.fibNumSeriesToString(fibonacciNumericalSeries) +
                        "<br>Максимальное число Фибоначчи: " + String.valueOf(fibonacci.maxNumberFibonacci(number)) +
                        "<br>Факториал: " + String.valueOf(factorial.searchOfFactorial(number)) +
                        "</html>", "Результат", JOptionPane.DEFAULT_OPTION);
            } else if (numericalSeriesFibonacciCheckBox.isSelected() && maxNumberOfFibonacciCheckBox.isSelected()
                    && (!factorialCheckBox.isSelected())){
                ArrayList<Integer> fibonacciNumericalSeries = fibonacci.numericalSeriesFibonacci(number);
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Ряд Фибоначчи: "
                        + fibonacci.fibNumSeriesToString(fibonacciNumericalSeries) +
                        "<br>Максимальное число Фибоначчи: " + String.valueOf(fibonacci.maxNumberFibonacci(number)) +
                        "</html>", "Результат", JOptionPane.DEFAULT_OPTION);
            } else if (numericalSeriesFibonacciCheckBox.isSelected() && (!maxNumberOfFibonacciCheckBox.isSelected())
                    && (!factorialCheckBox.isSelected())){
                ArrayList<Integer> fibonacciNumericalSeries = fibonacci.numericalSeriesFibonacci(number);
                JOptionPane.showMessageDialog(dialogJPanel, "Ряд Фибоначчи: "
                        + fibonacci.fibNumSeriesToString(fibonacciNumericalSeries),
                        "Результат", JOptionPane.DEFAULT_OPTION);
            } else if (numericalSeriesFibonacciCheckBox.isSelected() && (!maxNumberOfFibonacciCheckBox.isSelected())
                    && factorialCheckBox.isSelected()){
                ArrayList<Integer> fibonacciNumericalSeries = fibonacci.numericalSeriesFibonacci(number);
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Ряд Фибоначчи: "
                        + fibonacci.fibNumSeriesToString(fibonacciNumericalSeries) +
                        "<br>Факториал: " + String.valueOf(factorial.searchOfFactorial(number)) +
                        "</html>", "Результат", JOptionPane.DEFAULT_OPTION);
            } else if ((!numericalSeriesFibonacciCheckBox.isSelected()) && maxNumberOfFibonacciCheckBox.isSelected()
                    && factorialCheckBox.isSelected()){
                JOptionPane.showMessageDialog(dialogJPanel, "<html>Максимальное число Фибоначчи: " +
                        String.valueOf(fibonacci.maxNumberFibonacci(number)) +
                        "<br>Факториал: " + String.valueOf(factorial.searchOfFactorial(number)) +
                        "</html>", "Результат", JOptionPane.DEFAULT_OPTION);
            } if ((!numericalSeriesFibonacciCheckBox.isSelected()) && (!maxNumberOfFibonacciCheckBox.isSelected())
                    && factorialCheckBox.isSelected()){
                JOptionPane.showMessageDialog(dialogJPanel, "Факториал: " +
                        String.valueOf(factorial.searchOfFactorial(number)),
                        "Результат", JOptionPane.DEFAULT_OPTION);
            } if ((!numericalSeriesFibonacciCheckBox.isSelected()) && maxNumberOfFibonacciCheckBox.isSelected()
                    && (!factorialCheckBox.isSelected())){
                JOptionPane.showMessageDialog(dialogJPanel, "Максимальное число Фибоначчи: " +
                        String.valueOf(fibonacci.maxNumberFibonacci(number)),
                        "Результат", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
}
