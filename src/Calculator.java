import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Calculator implements ActionListener {
    JFrame frame = new JFrame("Basic Calculator");
    JPanel panel = new JPanel();
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, substractButton, multipleButton, divideButton, clearButton, deleteButton, minusButton, pointButton, equalsButton;
    Double number1, number2;
    char c;



    // creating all graphics
    Calculator() {
        // frame operations
        frame.setLayout(null);
        frame.setSize(420, 550);
        frame.setLocationRelativeTo(null);  // this method display the JFrame to center position of a screen

        // text field to show outpout
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(50, 25, 300, 50);


        //panel operations
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(50, 100, 300, 300);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new GridLayout(4, 4, 10, 10));


        // inicializations all buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);

        }
        // text for action buttons
        addButton = new JButton("+");
        substractButton = new JButton("-");
        multipleButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("clear");
        deleteButton = new JButton("delete");
        minusButton = new JButton("(-)");
        pointButton = new JButton(".");
        equalsButton = new JButton("=");

        // add action listener for action buttons
        addButton.addActionListener(this);
        substractButton.addActionListener(this);
        multipleButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        minusButton.addActionListener(this);
        pointButton.addActionListener(this);
        equalsButton.addActionListener(this);

        deleteButton.setBounds(50, 430, 100, 50);
        clearButton.setBounds(150, 430, 100, 50);
        minusButton.setBounds(250, 430, 100, 50);


        // add action buttons to panel
        panel.add(addButton);
        panel.add(substractButton);
        panel.add(multipleButton);
        panel.add(divideButton);
        panel.add(pointButton);
        panel.add(equalsButton);


        // show frame
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.add(clearButton);
        frame.add(deleteButton);
        frame.add(minusButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    // all actions background
    @Override
    public void actionPerformed(ActionEvent e) {
        // combines digits to numbers
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }


        if (e.getSource() == clearButton) {
            textField.setText("");
        }


        // delete last digit
        if (e.getSource() == deleteButton) {
            String lengthOf = textField.getText();
            textField.setText("");
            for (int i = 0; i < lengthOf.length() - 1; i++) {
                textField.setText(textField.getText() + lengthOf.charAt(i));
            }
        }

        //combines number and point
        if (e.getSource() == pointButton) {
            String lengthOf = textField.getText();
            // user can't write multiple times . in one number
            if (!lengthOf.contains(".")) {
                textField.setText(textField.getText().concat("."));
            }

        }


        // convert to negative number
        if (e.getSource() == minusButton) {

            String lengthOf = textField.getText();
            double value = Double.parseDouble(lengthOf) * (-1);
            textField.setText(String.valueOf(value));
        }


        if (e.getSource() == addButton) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            c = '+';
        }


        if (e.getSource() == substractButton) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            c = '-';
        }


        if (e.getSource() == multipleButton) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            c = '*';
        }


        if (e.getSource() == divideButton) {
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
            c = '/';
        }


        if (e.getSource() == equalsButton) {
            number2 = Double.parseDouble(textField.getText());
            switch (c) {
                case '+' -> {
                    number1 += number2;
                    textField.setText(String.valueOf(number1));
                }
                case '-' -> {
                    number1 -= number2;
                    textField.setText(String.valueOf(number1));
                }
                case '*' -> {
                    number1 *= number2;
                    textField.setText(String.valueOf(number1));
                }
                case '/' -> {
                    number1 /= number2;
                    textField.setText(String.valueOf(number1));
                }
                case '\0' -> {
                    textField.setText(String.valueOf(number2));
                }

            }

        }

    }


    // call constructor
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }
}