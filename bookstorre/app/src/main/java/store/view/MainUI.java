
package store.view;

import javax.swing.*;
import store.view.employee.*;

/**
 *
 * @author bourbon
 */
public class MainUI<ActionEvent> extends javax.swing.JFrame {
    private TableBook tableBookPanel; // Biến cho TableBook

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        tableBookPanel = new TableBook(); // Khởi tạo TableBook nhưng không thêm vào JFrame ngay
        this.add(tableBookPanel);
        tableBookPanel.setBounds(50, 50, 1100, 600);
        tableBookPanel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1200, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

}

// Variables declaration - do not modify//GEN-BEGIN:variables
// End of variables declaration//GEN-END:variables
