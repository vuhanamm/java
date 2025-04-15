/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.test.quickmath;

import com.test.quickmath.view.HomeJFrame;
import javax.swing.UIManager;

/**
 *
 * @author duyvu
 */
public class QuickMath {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new HomeJFrame().setVisible(true);
        });
    }
}
