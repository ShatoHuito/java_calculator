package com.myProgramm;

import javax.swing.*;
import static com.myProgramm.Calculator.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createPanelUI(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
}
