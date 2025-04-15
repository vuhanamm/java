package com.test.quickmath.view;

import com.test.quickmath.Constants;
import com.test.quickmath.controller.SettingController;
import com.test.quickmath.model.GameSettings;
import javax.swing.*;
import java.awt.*;

public class SettingJFrame extends JFrame {
    private JLabel userNameLabel;
    private JLabel levelLabel;
    private JLabel titleLabel;
    private JLabel digitsLabel;
    private JLabel rowsLabel;
    private JLabel intervalLabel;
    private JSpinner digitsSpinner;
    private JSpinner rowsSpinner;
    private JSpinner intervalSpinner;
    private JButton startButton;
    private SettingController controller;

    public SettingJFrame() {
        initComponents();
        setupUI();
        controller = new SettingController(this);
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            // Restore settings when showing the frame
            GameSettings settings = controller.getSettings();
            digitsSpinner.setValue(settings.getNumberOfQuestions());
            rowsSpinner.setValue(settings.getNumberOfDigits());
            intervalSpinner.setValue(settings.getTimeInterval());
        }
        super.setVisible(b);
    }

    // Add getter methods for controller
    public int getNumberOfQuestions() {
        return (int) digitsSpinner.getValue();
    }

    public int getNumberOfDigits() {
        return (int) rowsSpinner.getValue();
    }

    public double getTimeInterval() {
        return (double) intervalSpinner.getValue();
    }

    private void setupUI() {
        // Set frame properties
        setTitle("QuickMath - Challenge");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Constants.BACKGROUND_COLOR);
        setLayout(null);
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setLocationRelativeTo(null);

        // User info panel
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
        userPanel.setBackground(Constants.BACKGROUND_COLOR);
        userPanel.setBounds(10, 10, Constants.FRAME_WIDTH - 20, 50);


        userNameLabel = new JLabel("Xin chào");
        userNameLabel.setFont(Constants.LABEL_FONT);
        userPanel.add(userNameLabel);
        userPanel.add(Box.createHorizontalGlue());

        // Level
        levelLabel = new JLabel("Đã trả lời đúng 0 câu");
        levelLabel.setFont(Constants.LABEL_FONT);
        levelLabel.setBounds(0, 0, Constants.FRAME_WIDTH, Constants.BUTTON_HEIGHT);
        userPanel.add(levelLabel);
        add(userPanel);

        // Title
        titleLabel = new JLabel("Cài đặt câu hỏi");
        titleLabel.setFont(Constants.TITLE_FONT);
        titleLabel.setBounds(0, Constants.TITLE_Y_POSITION, Constants.FRAME_WIDTH, Constants.BUTTON_HEIGHT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        // Settings panel
        JPanel settingsPanel = new JPanel(null);
        settingsPanel.setBackground(Constants.BACKGROUND_COLOR);
        settingsPanel.setBounds(50, 140, 300, 200);

        // Digits setting
        digitsLabel = new JLabel("Số lượng");
        digitsLabel.setFont(Constants.LABEL_FONT);
        digitsLabel.setBounds(20, 20, 100, 30);
        settingsPanel.add(digitsLabel);

        digitsSpinner = new JSpinner(new SpinnerNumberModel(5, 5, Constants.MAX_DIGITS, 1));
        digitsSpinner.setBounds(150, 20, 80, 30);
        digitsSpinner.setFocusable(false);
        JComponent digitsEditor = digitsSpinner.getEditor();
        if (digitsEditor instanceof JSpinner.DefaultEditor defaultEditor) {
            JTextField textField = defaultEditor.getTextField();
            textField.setEditable(false); 
            textField.setFocusable(false);
        }
        JLabel digitsUnit = new JLabel("lần");
        digitsUnit.setFont(Constants.LABEL_FONT);
        digitsUnit.setBounds(240, 20, 50, 30);
        settingsPanel.add(digitsSpinner);
        settingsPanel.add(digitsUnit);

        // Rows setting
        rowsLabel = new JLabel("Số chữ số");
        rowsLabel.setFont(Constants.LABEL_FONT);
        rowsLabel.setBounds(20, 70, 100, 30);
        settingsPanel.add(rowsLabel);

        rowsSpinner = new JSpinner(new SpinnerNumberModel(Constants.MIN_DIGITS, Constants.MIN_DIGITS, Constants.MAX_DIGITS, 1));
        rowsSpinner.setBounds(150, 70, 80, 30);
        rowsSpinner.setFocusable(false);
        JComponent rowsEditor = rowsSpinner.getEditor();
        if (rowsEditor instanceof JSpinner.DefaultEditor defaultEditor) {
            JTextField textField = defaultEditor.getTextField();
            textField.setEditable(false); 
            textField.setFocusable(false);
        }
        JLabel rowsUnit = new JLabel("Số");
        rowsUnit.setFont(Constants.LABEL_FONT);
        rowsUnit.setBounds(240, 70, 50, 30);
        settingsPanel.add(rowsSpinner);
        settingsPanel.add(rowsUnit);

        // Interval setting
        intervalLabel = new JLabel("Thời gian");
        intervalLabel.setFont(Constants.LABEL_FONT);
        intervalLabel.setBounds(20, 120, 100, 30);
        settingsPanel.add(intervalLabel);

        intervalSpinner = new JSpinner(new SpinnerNumberModel(0.5, 0.5, Constants.MAX_INTERVAL, 0.5));
        intervalSpinner.setBounds(150, 120, 80, 30);
        JComponent intervalEditor = intervalSpinner.getEditor();    
        if (intervalEditor instanceof JSpinner.DefaultEditor defaultEditor) {
            JTextField textField = defaultEditor.getTextField();
            textField.setEditable(false); 
            textField.setFocusable(false);
        }
        JLabel intervalUnit = new JLabel("giây");
        intervalUnit.setFont(Constants.LABEL_FONT);
        intervalUnit.setBounds(240, 120, 50, 30);
        settingsPanel.add(intervalSpinner);
        settingsPanel.add(intervalUnit);

        add(settingsPanel);

        // Start button
        startButton = new JButton("Bắt đầu");
        startButton.setFont(Constants.BUTTON_FONT);
        startButton.setBackground(Constants.BUTTON_PINK);
        startButton.setBounds(Constants.HORIZONTAL_MARGIN, 380, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        add(startButton);
        
        startButton.addActionListener(e -> {
            controller.startGame();
        });
       
    }

    private void initComponents() {
    }
} 