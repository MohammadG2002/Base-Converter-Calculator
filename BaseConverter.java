import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseConverter {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Base Converter Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Enter number:");
        JTextField inputField = new JTextField(20);

        JRadioButton decimalButton = new JRadioButton("Decimal");
        JRadioButton binaryButton = new JRadioButton("Binary");
        JRadioButton hexButton = new JRadioButton("Hexadecimal");
        JRadioButton octalButton = new JRadioButton("Octal");

        ButtonGroup group = new ButtonGroup();
        group.add(decimalButton);
        group.add(binaryButton);
        group.add(hexButton);
        group.add(octalButton);

        decimalButton.setSelected(true);

        JButton convertButton = new JButton("Convert");

        JLabel decResult = new JLabel("Decimal: ");
        JLabel binResult = new JLabel("Binary: ");
        JLabel hexResult = new JLabel("Hexadecimal: ");
        JLabel octResult = new JLabel("Octal: ");

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                int number;

                try {
                    if (decimalButton.isSelected()) {
                        number = Integer.parseInt(input);
                    } else if (binaryButton.isSelected()) {
                        number = Integer.parseInt(input, 2);
                    } else if (hexButton.isSelected()) {
                        number = Integer.parseInt(input, 16);
                    } else if (octalButton.isSelected()) {
                        number = Integer.parseInt(input, 8);
                    } else {
                        number = 0;
                    }

                    decResult.setText("Decimal: " + number);
                    binResult.setText("Binary: " + Integer.toBinaryString(number));
                    hexResult.setText("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
                    octResult.setText("Octal: " + Integer.toOctalString(number));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid number for the selected base.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(decimalButton);
        frame.add(binaryButton);
        frame.add(hexButton);
        frame.add(octalButton);
        frame.add(convertButton);
        frame.add(decResult);
        frame.add(binResult);
        frame.add(hexResult);
        frame.add(octResult);

        frame.setVisible(true);
    }
}
