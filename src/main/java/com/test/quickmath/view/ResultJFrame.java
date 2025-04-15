package com.test.quickmath.view;

import com.test.quickmath.Constants;
import com.test.quickmath.controller.SettingController;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultJFrame extends JFrame {
    private final SettingController controller;
    private final String answer;
    private final boolean isCorrect;
    private final List<Integer> numbers;
    private JButton nextButton;
    private JButton reviewButton;
    private JButton settingsButton;

    public ResultJFrame(SettingController controller, String answer, boolean isCorrect) {
        this.controller = controller;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.numbers = new ArrayList<>();
        initComponents();
        setupUI();
    }

    public ResultJFrame(SettingController controller, String answer, boolean isCorrect, List<Integer> numbers) {
        this.controller = controller;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.numbers = numbers;
        initComponents();
        setupUI();
    }

    private void initComponents() {
        // Initialize any additional components if needed
    }

    private void setupUI() {
        setTitle("Quick Math - Result");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0x47, 0x47, 0x47));
        setLayout(null);
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setLocationRelativeTo(null);

        // Result label
        JLabel resultLabel = new JLabel(isCorrect ? "Đúng rồi!" : "Sai rồi!");
        resultLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 60));
        resultLabel.setForeground(isCorrect ? new Color(0x90, 0xF2, 0x2E) : new Color(0xFF, 0x47, 0x47));
        resultLabel.setBounds(0, 50, Constants.FRAME_WIDTH, 100);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        // Answer label
        JLabel answerLabel = new JLabel("Đáp án: " + answer);
        answerLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 40));
        answerLabel.setForeground(Color.WHITE);
        answerLabel.setBounds(0, 150, Constants.FRAME_WIDTH, 100);
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(answerLabel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 0));
        buttonPanel.setBackground(new Color(0x47, 0x47, 0x47));
        buttonPanel.setBounds(50, Constants.FRAME_HEIGHT - 150, Constants.FRAME_WIDTH - 100, 50);

        // Next button
        nextButton = createButton("Câu tiếp theo", new Color(0x90, 0xF2, 0x2E));
        nextButton.addActionListener(e -> {
            CountDownJFrame countDownFrame = new CountDownJFrame(controller);
            countDownFrame.setVisible(true);
            dispose();
        });

        // Review button
        reviewButton = createButton("Xem lại", new Color(0x90, 0xF2, 0x2E));
        reviewButton.addActionListener(e -> {
            if (numbers != null && !numbers.isEmpty()) {
                QuestionJFrame reviewFrame = new QuestionJFrame(controller, numbers);
                reviewFrame.setVisible(true);
                dispose();
            }
        });

        // Settings button
        settingsButton = createButton("Cài đặt", new Color(0x90, 0xF2, 0x2E));
        settingsButton.addActionListener(e -> {
            dispose();
            controller.showSettingScreen();
        });

        buttonPanel.add(nextButton);
        buttonPanel.add(reviewButton);
        buttonPanel.add(settingsButton);
        add(buttonPanel);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 20));
        button.setForeground(color);
        button.setBackground(new Color(0x33, 0x33, 0x33));
        button.setBorder(BorderFactory.createLineBorder(color, 2));
        button.setFocusPainted(false);
        return button;
    }
} 