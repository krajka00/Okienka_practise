package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

@SuppressWarnings("serial")

public class Framka extends JFrame  {

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
        setSize(760, 720);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 660, 483);
        setContentPane(panel);
        panel.setLayout(null);

        JButton btnRunButton = new JButton("Run");
        JButton btnCancel = new JButton("Cancel");

        btnRunButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random rand=new Random();
                if(getMousePosition().x<=btnRunButton.getX()+btnRunButton.getWidth() &&(getMousePosition().y>=btnRunButton.getY() ||
                        getMousePosition().y<=btnRunButton.getY()+btnRunButton.getHeight())){
                        Integer xCord = rand.nextInt(panel.getWidth() - btnRunButton.getWidth());
                        Integer yCord = rand.nextInt(panel.getHeight() - btnRunButton.getHeight());

                        if(xCord>btnCancel.getX()-btnCancel.getWidth() && xCord<btnCancel.getX()+btnCancel.getWidth()){
                            if(yCord>btnCancel.getY()-btnCancel.getHeight() && yCord<btnCancel.getY()+btnCancel.getHeight()){
                               Integer newXCOrd = xCord-100;
                               Integer newYCord = yCord-100;
                                btnRunButton.setLocation(newXCOrd, newYCord);
                            }
                            else
                                btnRunButton.setLocation(xCord, yCord);
                        }
                        else
                            btnRunButton.setLocation(xCord, yCord);
                    }

                }

        });
        btnRunButton.setBounds(10, 418, 155, 70);
        panel.add(btnRunButton);
        btnCancel.setBounds(580, 418, 155, 70);
        btnCancel.setBounds(580, 418, 155, 70);
        panel.add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnRunButton.setLocation(10,418);
            }
            });




    }


}


