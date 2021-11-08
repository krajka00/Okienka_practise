package com.company;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SwingWindow extends JFrame implements ActionListener   {
    JButton bOk, bCancel;
    JLabel lLogin, lHaslo;
    JTextField tHaslo,tLogin;
    String Login, Haslo;
    HashMap<String, String> LoginAndPassword = new HashMap<>();

    private JLabel label;

    public SwingWindow() {
        createInstances();
        addToFrame();
        configure();
        przycisk();
        data();



    }

    @Override
    public void actionPerformed(ActionEvent arg0){
        Object zrodlo = arg0.getSource();
        Login = tLogin.getText();
        Haslo = tHaslo.getText();
        if(zrodlo == bOk){
           // System.out.println(Login + Haslo);
            if (LoginAndPassword.containsKey(Login)){
                if(LoginAndPassword.containsValue(Haslo)){
                label.setBackground(Color.green);
                    System.out.println("OK");
                }
                else if(!LoginAndPassword.containsValue(Haslo)){
                    label.setBackground(Color.red);
                    System.out.println("nie ok");

                }

            }
            else if (!LoginAndPassword.containsKey(Login)) {
                label.setBackground(Color.red);
                System.out.println("Nie ok");
            }
        }
        else if(zrodlo==bCancel){
            dispose();
        }



    }

    private void przycisk(){

        lLogin = new JLabel("Login: ");
        lLogin.setBounds(50,50,50,20);
        add(lLogin);
        //setLayout(null);

        lHaslo = new JLabel("Haslo:");
        lHaslo.setBounds(50,80,50,20);
        add(lHaslo);

        tLogin = new JTextField("");
        tLogin.setBounds(150,50,250,20);
        add(tLogin);
        tHaslo = new JPasswordField("");
        tHaslo.setBounds(150,80,250,20);
        add(tHaslo);

        bOk = new JButton("OK");
        bOk.setBounds(100, 130, 100, 20 );
        add(bOk);
        bOk.addActionListener(this);
        bCancel = new JButton("Cancel");
        bCancel.setBounds(300,130,100,20);
        add(bCancel);
        bCancel.addActionListener(this);


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
        setLayout(null);
        label.setBackground(Color.red);
        label.setForeground(Color.blue);


    }
    private void data(){
        LoginAndPassword.put("Adam","haslo12345" );
        LoginAndPassword.put("Jan123","haslo12345" );
        LoginAndPassword.put("XDmobek","haslo12345" );
        LoginAndPassword.put("Wojtek22","haslo12345" );
        LoginAndPassword.put("stachuxd","haslo12345" );
        //System.out.println(LoginAndPassword);


    }
}