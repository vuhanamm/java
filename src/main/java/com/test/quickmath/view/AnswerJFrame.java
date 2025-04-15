package com.test.quickmath.view;

import com.test.quickmath.Constants;
import com.test.quickmath.controller.SettingController;
import javax.swing.*;
import java.awt.*;

public class AnswerJFrame extends JFrame {
    private JTextField answerField;
    private SettingController controller;
    private JPanel keypadPanel;
    private int correctAnswer;

    public AnswerJFrame(SettingController controller, int correctAnswer) {
        this.controller = controller;
        this.correctAnswer = correctAnswer;
        initComponents();
        setupUI();
    }

    private void setupUI() {
        // Set frame properties
        setTitle("Quick Math - Answer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Constants.BACKGROUND_COLOR);
        setLayout(null);
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setLocationRelativeTo(null);

        // Create input field panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(0, 50, Constants.FRAME_WIDTH, 100);
        inputPanel.setBackground(Constants.BACKGROUND_COLOR);
        add(inputPanel);

        // Add "Nhập câu trả lời" label
        JLabel inputLabel = new JLabel("Nhập câu trả lời");
        inputLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 24));
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputLabel.setBounds(0, 0, Constants.FRAME_WIDTH, 30);
        inputPanel.add(inputLabel);

        // Create answer text field
        answerField = new JTextField();
        answerField.setFont(new Font(Constants.FONT_FAMILY, Font.PLAIN, 32));
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        answerField.setBounds(50, 40, Constants.FRAME_WIDTH - 100, 50);
        answerField.setEditable(false); // Make it non-editable as we'll use the keypad
        inputPanel.add(answerField);

        // Create keypad panel
        keypadPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        keypadPanel.setBounds(50, 200, Constants.FRAME_WIDTH - 100, 300);
        keypadPanel.setBackground(Constants.BACKGROUND_COLOR);
        add(keypadPanel);

        // Add number buttons
        for (int i = 1; i <= 9; i++) {
            addButton(String.valueOf(i));
        }

        // Add special buttons
        addButton("⌫"); // Backspace
        addButton("0");
        addButton("✓"); // Check mark
    }

    private void addButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 24));
        button.setBackground(Color.LIGHT_GRAY);
        button.setFocusPainted(false);
        button.addActionListener(e -> {
            switch (text) {
                case "⌫":
                    if (answerField.getText().length() > 0) {
                        answerField.setText(answerField.getText().substring(0, answerField.getText().length() - 1));
                    }
                    break;
                case "✓":
                    try {
                        int userAnswer = Integer.parseInt(answerField.getText());
                        ResultJFrame resultFrame = new ResultJFrame(controller, answerField.getText(), userAnswer == correctAnswer);
                        resultFrame.setVisible(true);
                        dispose();
                    } catch (NumberFormatException ex) {
                        // Handle invalid input
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    answerField.setText(answerField.getText() + text);
                    break;
            }
        });
        keypadPanel.add(button);
    }

    private void initComponents() {
        // This method is intentionally left empty as we're using setupUI()
    }
} 