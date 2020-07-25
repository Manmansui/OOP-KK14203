/*
HAK CIPTA TERPELIHARA FIRMAN BIN RIDWAN (2020).
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class MyApps{
    public static JFrame frame;
    static Login log;

    public MyApps(){
        log = new Login();
        JFrame.setDefaultLookAndFeelDecorated(true);//to look better
        
        frame = new JFrame ("MyApps");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new LoginPanel(frame, log));
        frame.pack();
        frame.setVisible (true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    
    }
    
    public static void main (String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyApps();
            }
        });
        
        
    }
}