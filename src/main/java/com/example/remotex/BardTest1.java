package com.example.remotex;//time showing of system
//cross not working not visible
//not moving
//hr sec min formatting right 
//time elapsed right
//script executing in loop
// script stops upon adding 1 min,1 min working
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BardTest1 extends JFrame   {

    private JLabel elapsedTimeLabel;
    private JLabel timeToSessionOutLabel;
    private JButton setAlarmButton;
    private JTextField hourField;
    private JTextField minuteField;
    private JTextField secondField;
    private JButton startButton;
    private JButton postponeButton;
    private long startTime;
    private long sessionTime;
private int x =0;
    public BardTest1() {
        super("Session Countdown");
        setUndecorated(false); // Remove title bar

        // Create layout using a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(0, 1));

        // Elapsed time label at the top
        elapsedTimeLabel = new JLabel("Elapsed Time: 00:00:00", JLabel.CENTER);
        panel.add(elapsedTimeLabel);

        // Button to set alarm and input fields for session duration
        setAlarmButton = new JButton("Set Alarm");
        setAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputDialog();
            }
        });
        panel.add(setAlarmButton);

        // Label to display time remaining until session out
        timeToSessionOutLabel = new JLabel("", JLabel.CENTER);
        panel.add(timeToSessionOutLabel);

        // Start and postpone buttons in a horizontal FlowLayout
        startButton = new JButton("Start");
        startButton.setEnabled(true); // Initially disabled
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        postponeButton = new JButton("+1 Minute");
        postponeButton.setEnabled(false); // Initially disabled
        postponeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postponeCountdown();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);
        buttonPanel.add(postponeButton);
        panel.add(buttonPanel);

        // Apply desired look and feel using UIManager (optional)
        setLookAndFeel();

        // Set background color for the panel
        panel.setBackground(new Color(108, 96, 235));

        // Add the panel to the frame with BorderLayout
        add(panel, BorderLayout.CENTER);

        // Set window properties for location, closing behavior, visibility, size, and resizable state
        pack();
        setLocationRelativeTo(null); // Center on screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close on exit
        setVisible(true);
        setSize(300, 200); // Set initial size
        setResizable(false); // Make non-resizable

        // Start a timer to update elapsed time every second
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateElapsedTime();
            }
        }).start();
    }

    private void setLookAndFeel() {
        // You can set a custom look and feel here using UIManager
        // Example:  try { UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); } catch (Exception e) { e.printStackTrace(); }
    }

    private void showInputDialog() {
        // Create a separate panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(1, 6));
        inputPanel.add(new JLabel("Hours:"));
        hourField = new JTextField();
        inputPanel.add(hourField);
        inputPanel.add(new JLabel("Minutes:"));
        minuteField = new JTextField();
        inputPanel.add(minuteField);
        inputPanel.add(new JLabel("Seconds:"));
        secondField = new JTextField();
        inputPanel.add(secondField);

        // Prompt user for session countdown duration using JOptionPane
        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Enter Session Countdown", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Parse user input for hours, minutes, and seconds
                int hours = Integer.parseInt(hourField.getText());
                int minutes = Integer.parseInt(minuteField.getText());
                int seconds = Integer.parseInt(secondField.getText());
                
                // Validate user input for positive values
                if (hours < 0 || minutes < 0 || seconds < 0) {
                    JOptionPane.showMessageDialog(this, "Please enter positive values for countdown duration.");
                    return;
                }
                
                // Calculate session time in milliseconds
                sessionTime = (hours * 60 * 60 + minutes * 60 + seconds) * 1000;
                
                // Enable start button and disable set alarm button
                startButton.setEnabled(true);
                setAlarmButton.setEnabled(false);
                
                
                timeToSessionOutLabel.setText("Time to Session Out: 00:00:00"); // Reset display
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(this, "Please enter valid numbers for countdown duration.");
                            }
                        }
                    }
                
                    private void startTimer() {
                        startTime = System.currentTimeMillis(); 
                        // System.out.println((int)startTime);
                        // Capture start time
                        postponeButton.setEnabled(true); // Enable postpone button
                        startButton.setEnabled(false); // Disable start button
                    }
                
                    private void updateElapsedTime() {
                        long currentTime = System.currentTimeMillis();
                        long elapsedTime = currentTime - startTime;
                
                        // Calculate elapsed time in hours, minutes, and seconds
                        int hours = (int) (elapsedTime / (1000 * 60 * 60));
                        int minutes = (int) ((elapsedTime % (1000 * 60 * 60)) / (1000 * 60));
                        int seconds = (int) ((elapsedTime % (1000 * 60)) / 1000);
                
                        // Format elapsed time string
                        String elapsedTimeStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                        elapsedTimeLabel.setText("Elapsed Time: " + elapsedTimeStr);
                        // try {
                        //     Thread.sleep(1000);
                        // } catch (InterruptedException e) {
                        //     e.printStackTrace();
                        // }
                        if (sessionTime > 0) {
                            long timeRemaining = sessionTime - (currentTime - startTime);
                            if (timeRemaining <= 0 && x ==1) {
                                // Execute script (replace with your actual script execution logic)
                                System.out.println("Session Timed Out! Executing Script...");
                                timeRemaining = 0;
                            }
                
                            // Calculate remaining time in hours, minutes, and seconds
                            hours = (int) (timeRemaining / (1000 * 60 * 60));
                            minutes = (int) ((timeRemaining % (1000 * 60 * 60)) / (1000 * 60));
                            seconds = (int) ((timeRemaining % (1000 * 60)) / 1000);
                              
                            // Format remaining time string
                            String timeRemainingStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                            timeToSessionOutLabel.setText("Time to Session Out: " + timeRemainingStr);
                        }
                    }
                
                    private void postponeCountdown() {
                        sessionTime += 60000; // Add 1 minute to session time
                        updateElapsedTime(); // Update remaining time display
                    }
//
//                    public  void run(String[] args) {
//                        new BardTest1();
                    }

                
