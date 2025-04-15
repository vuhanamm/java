package com.test.quickmath.controller;

import com.test.quickmath.model.GameSettings;
import com.test.quickmath.view.SettingJFrame;
import com.test.quickmath.view.CountDownJFrame;

public class SettingController {
    private SettingJFrame view;
    private GameSettings model;

    public SettingController(SettingJFrame view) {
        this.view = view;
        this.model = new GameSettings(5, 1, 0.5); // Default values
    }

    public void startGame() {
        // Get values from view
        int questions = view.getNumberOfQuestions();
        int digits = view.getNumberOfDigits();
        double interval = view.getTimeInterval();

        // Update model
        model.setNumberOfQuestions(questions);
        model.setNumberOfDigits(digits);
        model.setTimeInterval(interval);

        // Show countdown and start game
        CountDownJFrame countdown = new CountDownJFrame(this);
        countdown.setVisible(true);
        view.dispose();
    }

    public GameSettings getSettings() {
        return model;
    }

    public void showSettingScreen() {
        view.setVisible(true);
    }
} 