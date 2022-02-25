package com.myProgramm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    static JTextField num_field;

    static JButton plusButton, minusButton, multiplyButton, divideButton, clearButton, equalButton;
    static int num;

    static Keys keyBuf = Keys.NULL;

    enum Keys{
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        CLEAR,
        EQUAL,
        NULL
    }

    public static void createPanelUI(Container container) {
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridy   = 0  ;  // нулевая ячейка таблицы по вертикали

        num_field = new JTextField(10);
        num_field.setText("0");

        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.ipady     = 50;
        constraints.ipadx = 100;

        container.add(num_field, constraints);

        plusButton = new JButton(String.valueOf(Keys.PLUS));
        minusButton = new JButton(String.valueOf(Keys.MINUS));
        multiplyButton = new JButton(String.valueOf(Keys.MULTIPLY));
        divideButton = new JButton(String.valueOf(Keys.DIVIDE));
        clearButton = new JButton(String.valueOf(Keys.CLEAR));
        equalButton = new JButton(String.valueOf(Keys.EQUAL));

        plusButton.setBackground(Color.GREEN);
        minusButton.setBackground(Color.red);
        multiplyButton.setBackground(Color.YELLOW);
        divideButton.setBackground(Color.PINK);
        clearButton.setBackground(Color.orange);
        equalButton.setBackground(Color.GRAY);

        constraints.gridwidth = 1;
        constraints.gridx     = 0;
        constraints.gridy     = 1;
        container.add(plusButton, constraints);
        constraints.gridx     = 1;
        container.add(minusButton,constraints);
        constraints.gridx     = 0;
        constraints.gridy     = 2;
        container.add(multiplyButton, constraints);
        constraints.gridx     = 1;
        container.add(divideButton, constraints);
        constraints.gridx     = 0;
        constraints.gridy     = 3;
        container.add(clearButton, constraints);
        constraints.gridx     = 1;
        container.add(equalButton, constraints);

        plusButton.addActionListener(new ButtonEventManager());
        minusButton.addActionListener(new ButtonEventManager());
        multiplyButton.addActionListener(new ButtonEventManager());
        divideButton.addActionListener(new ButtonEventManager());
        equalButton.addActionListener(new ButtonEventManager());
        clearButton.addActionListener(new ButtonEventManager());
    }

    static class ButtonEventManager implements ActionListener{

        private void action(Keys command) {
            int numBuf = Integer.parseInt(num_field.getText());

            switch (command) {
                case PLUS:
                    num += numBuf;
                    break;
                case MINUS:
                    num -= numBuf;
                    break;
                case MULTIPLY:
                    num *= numBuf;
                    break;
                case DIVIDE:
                    num /= numBuf;
                    break;
                case NULL:
                    num = numBuf;
                    break;
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Keys command = Keys.valueOf(e.getActionCommand());

            switch (command){
                case PLUS, MINUS, MULTIPLY, DIVIDE:
                    action(keyBuf);
                    keyBuf = command;
                    num_field.setText("0");
                    break;
                case CLEAR:
                    num = 0;
                    num_field.setText("0");
                    break;
                case EQUAL:
                    action(keyBuf);
                    keyBuf = Keys.NULL;
                    num_field.setText(Integer.toString(num));
                    num = 0;
                    break;
            }
        }
    }
}
