package com.company;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    JLabel label;

    public SwingWindow() {
        //createInstances();
        //addToFrame();
        if(1==1) {
            configure();
            przycisk();
            data();
            }
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
                    lLogin.setBackground(Color.white);
                    lHaslo.setBackground(Color.white);
                    label.setBackground(Color.green);
                }
                else if(!LoginAndPassword.containsValue(Haslo)){
                    label.setBackground(new Color(231, 57, 57));
                    //System.out.println("nie ok");

                }

            }
            else if (!LoginAndPassword.containsKey(Login)) {
                label.setBackground(new Color(231, 57, 57));
            }
        }
        else if(zrodlo==bCancel){
            dispose();
        }
    }

    private void przycisk(){

        tLogin = new JTextField("");
        tLogin.setBounds(150,50,250,20);
        tLogin.setBackground(Color.white);
        tLogin.setForeground(Color.black);
        tLogin.setOpaque(true);
        add(tLogin);
        tHaslo = new JPasswordField("");
        tHaslo.setBounds(150,80,250,20);
        tHaslo.setForeground(Color.black);
        tHaslo.setBackground(Color.white);
        tHaslo.setOpaque(true);
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


    private void configure() {
        setTitle("Panel logowania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(512, 256);
        lLogin = new JLabel("Login: ");
        lLogin.setBounds(50,50,50,20);
        lLogin.setBackground(Color.white);
        lLogin.setOpaque(true);
        add(lLogin);

        lHaslo = new JLabel("Haslo:");
        lHaslo.setBounds(50,80,50,20);
        lHaslo.setBackground(Color.white);
        lHaslo.setOpaque(true);
        add(lHaslo);
        setLayout(null);
        label = new JLabel("");
        label.setBounds(0,0,512,256);
        label.setOpaque(true);
        label.setBackground(Color.white);
        this.add(label);
    }

    private void data(){
        LoginAndPassword.put("Gracz1","haslo12345" );
        LoginAndPassword.put("Jan123","haslo1234" );
        LoginAndPassword.put("Kacper6","haslo123" );
        LoginAndPassword.put("Wojtek","haslo12" );
        LoginAndPassword.put("Marcin","haslo1" );
        //System.out.println(LoginAndPassword);


    }
}