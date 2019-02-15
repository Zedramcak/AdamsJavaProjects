package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JButton button = new JButton("Press");
        JButton button2 = new JButton("PRESS ME");
        JTextField area = new JTextField();
        area.setText("TESTING");

        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.getContentPane().add(BorderLayout.WEST, button2);
        frame.getContentPane().add(BorderLayout.NORTH, area);
        frame.setVisible(true);
    }
}
