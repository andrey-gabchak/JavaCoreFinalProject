import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by coura on 11.04.2016.
 */
public class Window extends JFrame {

    private JCheckBox numberSeriesFibinacciCheckBox;
    private JCheckBox maxNumberOfFibonacciCheckBox;
    private JCheckBox factorialCheckBox;
    private JButton findButton;
    private JTextField textField3;

    public Window(int wigth, int height) {
        setVisible(true); //show program window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closing the window when you click on the cross
        setSize(wigth, height); //set size window program

        getContentPane().setLayout(null);

        numberSeriesFibinacciCheckBox = new JCheckBox(String.valueOf(JTabbedPane.CENTER));
        numberSeriesFibinacciCheckBox.setBounds(10, 10, 30, 30);
        getContentPane().add(numberSeriesFibinacciCheckBox);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 81, 605, 350);
        getContentPane().add(tabbedPane);


    }

}
