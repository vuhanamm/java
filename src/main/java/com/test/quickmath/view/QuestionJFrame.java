package com.test.quickmath.view;

import com.test.quickmath.Constants;
import com.test.quickmath.controller.SettingController;
import com.test.quickmath.model.GameSettings;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class QuestionJFrame extends JFrame {
    private Timer timer;
    private SettingController controller;
    private JLabel numberLabel;
    private int currentQuestionIndex = 0;
    private Random random = new Random();
    private List<Integer> numbers;
    private int totalSum = 0;
    private boolean isReviewMode = false;

    public QuestionJFrame(SettingController controller) {
        this.controller = controller;
        this.numbers = new ArrayList<>();
        initComponents();
        setupUI();
        generateNumbers();
        startQuestions();
    }

    // Constructor for review mode
    public QuestionJFrame(SettingController controller, List<Integer> numbersToReview) {
        this.controller = controller;
        this.numbers = numbersToReview;
        this.isReviewMode = true;
        initComponents();
        setupUI();
        startQuestions();
    }

    private void setupUI() {
        // Set frame properties
        setTitle("Quick Math - " + (isReviewMode ? "Review" : "Question"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(0x47, 0x47, 0x47)); // Dark gray background
        setLayout(null);
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setLocationRelativeTo(null);

        // Create panel for number display
        JPanel numberPanel = new JPanel(new GridBagLayout());
        numberPanel.setBounds(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        numberPanel.setBackground(new Color(0x47, 0x47, 0x47)); // Dark gray background
        add(numberPanel);

        // Create number label
        numberLabel = new JLabel("");
        numberLabel.setFont(new Font(Constants.FONT_FAMILY, Font.BOLD, 150));
        numberLabel.setForeground(new Color(0x90, 0xF2, 0x2E)); // Light green text
        numberPanel.add(numberLabel);
    }

    private void generateNumbers() {
        GameSettings settings = controller.getSettings();
        numbers.clear();
        totalSum = 0;
        
        // Generate all numbers first
        for (int i = 0; i < settings.getNumberOfQuestions(); i++) {
            int number = generateRandomNumber(settings.getNumberOfDigits());
            numbers.add(number);
            totalSum += number;
        }
        System.out.println("Total sum: " + totalSum); // For debugging
    }

    private void startQuestions() {
        GameSettings settings = controller.getSettings();
        currentQuestionIndex = 0;
        
        // Calculate total sum if not in review mode
        if (!isReviewMode) {
            totalSum = numbers.stream().mapToInt(Integer::intValue).sum();
        }
        
        // Show first number
        showNextNumber();
        
        // Create timer for showing numbers
        timer = new Timer((int)(settings.getTimeInterval() * 1000), e -> {
            currentQuestionIndex++;
            if (currentQuestionIndex < numbers.size()) {
                showNextNumber();
            } else {
                // All numbers shown
                timer.stop();
                if (!isReviewMode) {
                    // Show answer screen only in normal mode
                    AnswerJFrame answerFrame = new AnswerJFrame(controller, totalSum);
                    answerFrame.setVisible(true);
                }
                dispose();
            }
        });
        timer.start();
    }

    private void showNextNumber() {
        if (currentQuestionIndex < numbers.size()) {
            numberLabel.setText(String.valueOf(numbers.get(currentQuestionIndex)));
        }
    }

    private int generateRandomNumber(int digits) {
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        return min + random.nextInt(max - min + 1);
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