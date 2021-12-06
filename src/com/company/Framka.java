package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

@SuppressWarnings("serial")

public class Framka extends JFrame {

    public static void FramkaStart() {
        SwingUtilities.invokeLater(() -> {
            new Framka("Mouse teser").start();
        });
    }

    private void start() {
        setVisible(true);
    }


    public Framka() throws HeadlessException {
        this("untitled");
    }

    public Framka(String title) throws HeadlessException {
        super(title);
        setTitle("Panel logowania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 508);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 660, 483);
        setContentPane(panel);
        panel.setLayout(null);

        JButton btnRunButton = new JButton("Run");
        btnRunButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rand=new Random();
                Integer xCord = rand.nextInt(660);
                Integer yCord = rand.nextInt(483);
                btnRunButton.setLocation(xCord, yCord);
            }
        });
        btnRunButton.setBounds(0, 418, 156, 71);
        panel.add(btnRunButton);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(584, 412, 156, 71);
        panel.add(btnCancel);

    }
}

