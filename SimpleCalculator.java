import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener
{
    private JTextField textField;
    private double num1, num2, result;
    private char operator;

    public SimpleCalculator()
    {
        // Set up the frame
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);

        // Create buttons for digits and operations
        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
        }

        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(this);
        JButton equalButton = new JButton("=");
        equalButton.addActionListener(this);
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(this);

        // Create the layout
        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(digitButtons[1]);
        panel.add(digitButtons[2]);
        panel.add(digitButtons[3]);
        panel.add(addButton);

        panel.add(digitButtons[4]);
        panel.add(digitButtons[5]);
        panel.add(digitButtons[6]);
        panel.add(subtractButton);

        panel.add(digitButtons[7]);
        panel.add(digitButtons[8]);
        panel.add(digitButtons[9]);
        panel.add(multiplyButton);

        panel.add(clearButton);
        panel.add(digitButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.')
        {
            textField.setText(textField.getText() + command);
        }

        else if (command.charAt(0) == 'C')
        {
            textField.setText("");
            num1 = num2 = result = 0;
            operator = '\0';
        }

        else if (command.charAt(0) == '=')
        {
            num2 = Double.parseDouble(textField.getText());
            switch (operator)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
            operator = '\0';
        }

        else
        {
            operator = command.charAt(0);
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }

    public static void main(String[] args)
    {
        SimpleCalculator a = new SimpleCalculator();
    }
}
