package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SwingWindow extends JFrame implements ActionListener   {
    JButton bOk, bCancel;
    JButton bWyjscie;
    JLabel lLogin, lHaslo, lWyswietlDate;
    JTextField tHaslo,tLogin;

    private JLabel label;

    public SwingWindow() {
        createInstances();
        addToFrame();
        configure();
        przycisk();



    }

    @Override
    public void actionPerformed(ActionEvent arg0){
        Object zrodlo = arg0.getSource();
        if(zrodlo == bOk) {
            lWyswietlDate.setText(new Date().toString());
            //System.out.println(new Date());
        }
        else if(zrodlo == bWyjscie){
            dispose();
        }

    }


    private void przycisk(){

        lLogin = new JLabel("Login: ");
        lLogin.setBounds(50,30,50,20);
        add(lLogin);
        setLayout(null);
        lHaslo = new JLabel("Haslo:");
        lHaslo.setBounds(50,60,50,20);
        add(lHaslo);
        tLogin = new JTextField();
        tLogin.setBounds(150,30,150,0);
        add(tLogin);

        bOk = new JButton("OK");
        bOk.setBounds(100, 100, 100, 20 );
        add(bOk);
        bOk.addActionListener(this );
        bCancel = new JButton("Cancel");
        bCancel.setBounds(300,100,100,20);
        add(bCancel);


    }
    private void createInstances() {
        label = new JLabel("", SwingConstants.CENTER);

    }

    private void addToFrame() {
        getContentPane().add(label);
    }

    private void configure() {
        setTitle("Panel logowania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(512, 256);
        setLocationRelativeTo(null);


    }
}