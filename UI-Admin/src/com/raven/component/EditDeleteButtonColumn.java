/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author DELL
 */
public class EditDeleteButtonColumn extends javax.swing.JPanel {

    /**
     * Creates new form EditDeleteButtonColumn
     */
     public EditDeleteButtonColumn() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        
        add(editButton);
        add(Box.createHorizontalStrut(5)); // Add some space between buttons
        add(deleteButton);
        
        editButton.addActionListener(e -> {
            // Open your edit form here
            System.out.println("Edit button clicked");
        });
        
        deleteButton.addActionListener(e -> {
            // Delete row action here
            JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, this);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.rowAtPoint(((JButton)e.getSource()).getLocation());
            model.removeRow(row);
        });
    }
    
    public JButton getEditButton() {
        return (JButton) getComponent(0);
    }
    
    public JButton getDeleteButton() {
        return (JButton) getComponent(2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
