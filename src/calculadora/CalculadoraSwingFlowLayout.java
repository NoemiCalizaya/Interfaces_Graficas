package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSwingFlowLayout extends JFrame {
    private JTextField txtDisplay;

    private double num1;
    private String operator;

    public CalculadoraSwingFlowLayout() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 400);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtDisplay = new JTextField();
        txtDisplay.setPreferredSize(new Dimension(280, 40));
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        txtDisplay.setEditable(false);
        add(txtDisplay);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setPreferredSize(new Dimension(70, 70));
            button.addActionListener(new ButtonClickListener());
            add(button);
        }

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = command;
                    num1 = Double.parseDouble(txtDisplay.getText());
                    txtDisplay.setText("");
                    break;
                case "=":
                    double num2 = Double.parseDouble(txtDisplay.getText());
                    double result = calcularResultado(num1, num2, operator);
                    txtDisplay.setText(String.valueOf(result));
                    break;
                default:
                    txtDisplay.setText(txtDisplay.getText() + command);
                    break;
            }
        }

        private double calcularResultado(double num1, double num2, String operator) {
            switch (operator) {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    return num1 / num2;
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraSwingFlowLayout());
    }
}
