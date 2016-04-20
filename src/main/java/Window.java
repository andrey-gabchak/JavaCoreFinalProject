import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton fibSeqButton;
    private JRadioButton factorialButton;
    private JTextField inputNumberTextField;
    private JPanel dialogJPanel;

    public static void main(String[] args) {

        Window window = new Window();
        window.descriptionField();
        window.seqButton();
    }

    public Window() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setTitle("Fibonacci and Factorial");
        setResizable(false);

        fibSeqButton = new JRadioButton("Fibonacci Sequence", false);
        factorialButton = new JRadioButton("Factorial", true);
        group.add(fibSeqButton);
        group.add(factorialButton);
        inputNumberTextField = new JTextField();
        dialogJPanel = new JPanel();
    }


    private void descriptionField() {
        JPanel descriptionPanel = new JPanel();
        add(descriptionPanel);
        JLabel descriptionField = new JLabel("<html>The program is designed to calculate the factorial" +
                "<br> or a Fibonacci sequence." +
                "<br>Enter the number for the calculation:</html>");
        add(descriptionField,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 3), 0, 0));
        descriptionPanel.add(descriptionField);
    }

    private void seqButton() {
        JButton findButton = new JButton("Calculate!");
        add(fibSeqButton,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 3), 0, 0));
        add(inputNumberTextField,
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(7, 5, 5, 3), 0, 0));
        add(factorialButton,
                new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                        GridBagConstraints.HORIZONTAL, new Insets(2, 5, 5, 3), 0, 0));
        add(findButton,
                new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(12, 5, 5, 3), 0, 0));
        findButton.addActionListener(new FindButtonActionListener());

        setVisible(true);
        pack();
    }


    private class FindButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String inputData = inputNumberTextField.getText();

            int enteredInteger;

            String message;
            try {
                enteredInteger = Integer.parseInt(inputData);
                outputResult(enteredInteger);
            } catch (NumberFormatException nfe) {
                message = "Invalid input! \n For the calculation you must enter " +
                        "positive integer.";
                results(message);
            } catch (NegativeIntegerException nie) {
                message = "It is not possible to calculate negative numbers to calculate " +
                        "You must enter a positive integer.";
                results(message);

            } catch (UpperLimitException ule) {
                message = "Unable factorial calculation for the number of > 170 \n For " +
                        "calculation" +
                        " you must enter a positive integer from 1 to 170.";
                results(message);
            }
        }

        private void results(String message) {
            String result = "Error";
            JOptionPane.showMessageDialog(dialogJPanel, message, result, JOptionPane
                    .DEFAULT_OPTION);

        }

        private void outputResult(int number) throws NegativeIntegerException, UpperLimitException {

            if (fibSeqButton.isSelected()) {
                FibonacciSequence fibonacci = new FibonacciSequence();
                fibonacci.checkInteger(number);
                ArrayList<Integer> fibonacciSequence = fibonacci.getFibSeq(number);
                JOptionPane.showMessageDialog(dialogJPanel, "Fibonacci sequence: "
                        + fibonacciSequence, "Result", JOptionPane.DEFAULT_OPTION);
            }

            if (factorialButton.isSelected()) {
                Factorial factorial = new Factorial();
                factorial.checkInteger(number);
                JOptionPane.showMessageDialog(dialogJPanel, "Factorial: " + String.valueOf(factorial
                                .getFactorial(number))
                        , "Result", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
}