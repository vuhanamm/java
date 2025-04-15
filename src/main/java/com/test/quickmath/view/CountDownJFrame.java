package com.test.quickmath.view;

import com.test.quickmath.Constants;
import com.test.quickmath.controller.SettingController;
import javax.swing.*;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CountDownJFrame extends JFrame {
    private Timer timer;
    private SettingController controller;

    public CountDownJFrame(SettingController controller) {
        this.controller = controller;
        initComponents();
        setupUI();
    }

    private void setupUI() {
        // Set frame properties
        setTitle("Quick Math - Countdown");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0x47, 0x47, 0x47)); // Dark gray background
        setLayout(null);
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setLocationRelativeTo(null);

        // Back button using JLabel
        JLabel backButton = new JLabel("←");
        backButton.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 32));
        backButton.setBounds(20, 10, 60, 60);
        backButton.setForeground(new Color(0x90, 0xF2, 0x2E));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controller.showSettingScreen();
                dispose();
            }
        });
        add(backButton);

        // Create a panel for the countdown
        JPanel countdownPanel = new JPanel();
        countdownPanel.setLayout(new GridBagLayout());
        countdownPanel.setBounds(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        countdownPanel.setBackground(new Color(0x47, 0x47, 0x47)); // Dark gray background
        add(countdownPanel);

        // Create ready label
        JLabel readyLabel = new JLabel("Sẵn sàng trong");
        readyLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 32));
        readyLabel.setForeground(new Color(0x90, 0xF2, 0x2E)); // Light green text
        
        // Create countdown label
        JLabel countLabel = new JLabel("3");
        countLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 200));
        countLabel.setForeground(new Color(0x90, 0xF2, 0x2E)); // Light green text

        // Add components to panel with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0); // Add some space between labels
        countdownPanel.add(readyLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        countdownPanel.add(countLabel, gbc);

        // Start countdown timer
        int[] count = {3};
        timer = new Timer(1000, e -> {
            count[0]--;
            if (count[0] > 0) {
                countLabel.setText(String.valueOf(count[0]));
            } else {
                timer.stop();
                QuestionJFrame questionFrame = new QuestionJFrame(controller);
                questionFrame.setVisible(true);
                dispose();
            }
        });
        timer.start();
    }

    private void initComponents() {
        // This method is intentionally left empty as we're using setupUI()
    }

    @Override
    public void dispose() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        super.dispose();
    }
} 