import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.net.URI;
public class QuizController {
    // Index to track the current question
    private int currentQuestionIndex = 0;
    // Questions and answers
    private String[][] questions = {
            {"2 + 2", "4"},
            {"3 * 2", "6"},
            {"10 - 5", "5"}
    };
    // Main frame for the GUI
    private JFrame frame;
    // Panel to hold the components
    private JPanel panel;
    // Label to display the current question
    private JLabel questionLabel;
    // Text field for the user to enter their answer
    private JTextField answerField;
    // Button to submit the answer
    private JButton submitButton;
    // Button to open a web page upon completing the quiz
    private JButton learnMoreButton;
    // Label to give feedback based on the user's answer
    private JLabel feedbackLabel;
    // Constructor to set up the GUI
    public QuizController() {
        frame = new JFrame("Math Quiz Game 🎮"); // Create a frame with a title
        panel = new JPanel(); // Initialize the panel
        panel.setBackground(new Color(255, 255, 204)); // Set a light yellow background color for the panel
        questionLabel = new JLabel("What's " + questions[currentQuestionIndex][0] + "?"); // Initialize the question label
        questionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18)); // Set the font
        answerField = new JTextField(10); // Initialize the text field with a width of 10 columns
        answerField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16)); // Set the font of the answer field
        submitButton = new JButton("Check Answer"); // Initialize the submit button
        learnMoreButton = new JButton("The Winner Button!"); // Initialize the "Learn More" button
        learnMoreButton.setEnabled(false); // Initially disable the "Learn More" button
        feedbackLabel = new JLabel(""); // Initialize the feedback label
        feedbackLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); // Set the font of the feedback label
        // Add components to the panel
        panel.add(questionLabel);
        panel.add(answerField);
        panel.add(submitButton);
        panel.add(feedbackLabel);
        panel.add(learnMoreButton);
        frame.add(panel);
        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(); // Check the user's answer when the button is clicked
            }
        });
        // Add action listener to the "Learn More" button
        learnMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://www.youtube.com/watch?v=h3uBr0CCm58&pp=ygUFbm9pY2U%3D"); // Open the link when the button is clicked
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setSize(500, 300); // Set the size of the frame
        frame.setVisible(true); // Make the frame visible
    }
    // Method to check the user's answer
    private void checkAnswer() {
        String userAnswer = answerField.getText().trim(); // Get the text from the answer field and trim whitespace
        if (userAnswer.equals(questions[currentQuestionIndex][1])) { // If the answer is correct
            currentQuestionIndex++; // Increment to the next question
            if (currentQuestionIndex < questions.length) { // If there are more questions
                questionLabel.setText("What's " + questions[currentQuestionIndex][0] + "?"); // Update the question label
                feedbackLabel.setText("<html>Correct! Awesome job! Next question:</html>"); // Set feedback message
            } else {
                feedbackLabel.setText("<html>Yay! You've completed all questions! Click the winner button!</html>"); // Set completion message
                submitButton.setEnabled(false); // Disable the submit button
                learnMoreButton.setEnabled(true); // Enable the "The Winner Button" button
            }
        } else {
            feedbackLabel.setText("<html>Oops! Try again, you can do it!</html>"); // Set feedback message for incorrect answer
        }
        answerField.setText(""); // Clear the answer field
    }
    // Open the URL link
    private void openWebPage(String url) {
        try {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(url)); // Open the URL
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





/* import javax.swing.SwingUtilities;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizController();
            }
        });
    }
}*/

