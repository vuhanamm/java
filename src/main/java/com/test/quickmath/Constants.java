package com.test.quickmath;

import java.awt.Color;
import java.awt.Font;

public class Constants {
    // Frame dimensions
    public static final int FRAME_WIDTH = 400;
    public static final int FRAME_HEIGHT = 600;
    
    // Colors
    public static final Color BACKGROUND_COLOR = new Color(220, 237, 200);  // Light green background
    public static final Color BUTTON_PINK = new Color(255, 182, 193);       // Pink for buttons
    public static final Color BUTTON_ORANGE = new Color(255, 198, 93);      // Orange for buttons
    public static final Color BUTTON_LIGHT_BLUE = new Color(135, 206, 250); // Light blue for buttons
    public static final Color AD_PANEL_COLOR = new Color(65, 105, 225);     // Blue for ad panel
    
    // Fonts
    public static final String FONT_FAMILY = "Yu Gothic UI";
    public static final Font TITLE_FONT = new Font(FONT_FAMILY, Font.BOLD, 32);
    public static final Font BUTTON_FONT = new Font(FONT_FAMILY, Font.PLAIN, 20);
    public static final Font LABEL_FONT = new Font(FONT_FAMILY, Font.PLAIN, 18);
    public static final Font SMALL_FONT = new Font(FONT_FAMILY, Font.PLAIN, 14);
    
    // Component dimensions
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 50;
    public static final int TITLE_Y_POSITION = 50;
    public static final int FIRST_BUTTON_Y = 150;
    public static final int BUTTON_SPACING = 70;
    public static final int HORIZONTAL_MARGIN = 100;  // (FRAME_WIDTH - BUTTON_WIDTH) / 2
    
    // Challenge screen constants
    public static final int MIN_DIGITS = 1;
    public static final int MAX_DIGITS = 10;
    public static final double MAX_INTERVAL = 10.0;
} 