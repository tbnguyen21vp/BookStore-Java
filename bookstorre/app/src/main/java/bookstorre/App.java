
package bookstorre;

import javax.swing.*;

import view.auth.*;

import java.awt.*;

import view.auth.NewJPanel;

public class App {

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin().setVisible(true);
            }
        });
    

      
    }

}
