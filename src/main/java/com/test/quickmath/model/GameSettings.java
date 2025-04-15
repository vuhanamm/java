package com.test.quickmath.model;

public class GameSettings {
    private int numberOfQuestions;
    private int numberOfDigits;
    private double timeInterval;

    public GameSettings(int numberOfQuestions, int numberOfDigits, double timeInterval) {
        this.numberOfQuestions = numberOfQuestions;
        this.numberOfDigits = numberOfDigits;
        this.timeInterval = timeInterval;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public double getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(double timeInterval) {
        this.timeInterval = timeInterval;
    }
} 