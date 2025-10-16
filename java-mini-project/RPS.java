import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RPS {

    private static final String Rock = "Rock";
    private static final String Paper = "Paper";
    private static final String Scissors = "Scissors";

    // Variables for Score Card:
    private static int userScore = 0;
    private static int computerScore = 0;
    private static int drawCount = 0;

    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Rock, Paper & Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setLayout(null);
        frame.setResizable(false);

        // Background Image
        ImageIcon image1 = new ImageIcon("/Users/pranavghodke/Desktop/KIRO/java-mini-project/RPS.png"); 
        Image image2 = image1.getImage();
        Image image3 = image2.getScaledInstance(1450, 900, Image.SCALE_SMOOTH);
        ImageIcon image4 = new ImageIcon(image3);
        JLabel imagelabel1 = new JLabel(image4);
        imagelabel1.setBounds(0, 0, 1450, 900);
        imagelabel1.setLayout(null); // Important so we can set bounds for child components

        // Title Label
        JLabel lab = new JLabel("Rock, Paper & Scissors", SwingConstants.CENTER);
        lab.setBounds(300, 20, 700, 80);
        lab.setFont(new Font("SansSerif", Font.BOLD, 40));
        lab.setForeground(Color.BLACK);

        // Result Label
        JLabel resultLabel = new JLabel("Choose your move", SwingConstants.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
        resultLabel.setBounds(10, 320, 1300, 70);
        resultLabel.setForeground(Color.BLACK);

        // Score Card Label
        JLabel scoreLabel = new JLabel("Score: User 0 - Computer 0 - Draws 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        scoreLabel.setBorder(border);
        scoreLabel.setBounds(200, 250, 900, 70);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(new Color(255, 255, 255, 150)); // semi-transparent white

        // Buttons
        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        rockButton.setBounds(510, 400, 300, 50);
        paperButton.setBounds(510, 480, 300, 50);
        scissorsButton.setBounds(510, 550, 300, 50);

        // Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(600, 630, 120, 50);
        resetButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Action Listeners for Buttons
        rockButton.addActionListener(e -> playGame(Rock, resultLabel, scoreLabel));
        paperButton.addActionListener(e -> playGame(Paper, resultLabel, scoreLabel));
        scissorsButton.addActionListener(e -> playGame(Scissors, resultLabel, scoreLabel));

        // Reset Action Listener
        resetButton.addActionListener(e -> {
            userScore = 0;
            computerScore = 0;
            drawCount = 0;
            scoreLabel.setText("Score: User 0 - Computer 0 - Draws 0");
            resultLabel.setText("Game Reset! Choose your move");
        });

        // Hover effects for buttons
        setupHoverEffect(rockButton);
        setupHoverEffect(paperButton);
        setupHoverEffect(scissorsButton);
        setupHoverEffect(resetButton);

        // Add all components to image label (so they appear on top of background)
        imagelabel1.add(lab);
        imagelabel1.add(resultLabel);
        imagelabel1.add(scoreLabel);
        imagelabel1.add(rockButton);
        imagelabel1.add(paperButton);
        imagelabel1.add(scissorsButton);
        imagelabel1.add(resetButton);

        // Add image label (with all components) to frame
        frame.add(imagelabel1);

        frame.setVisible(true);
    }

    // Play the game and display the result
    private static void playGame(String userChoice, JLabel resultLabel, JLabel scoreLabel) {
        String computerChoice = getComputerChoice();
        String result = determineWinner(userChoice, computerChoice);

        if (result.equals("You win!")) {
            userScore++;
        } else if (result.equals("You lose!")) {
            computerScore++;
        } else {
            drawCount++;
        }

        resultLabel.setText("You: " + userChoice + ", Computer: " + computerChoice + " → " + result);
        scoreLabel.setText("Score: User " + userScore + " - Computer " + computerScore + " - Draws " + drawCount);
    }

    // Random computer choice
    private static String getComputerChoice() {
        String[] choices = {Rock, Paper, Scissors};
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    // Determine the winner
    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a draw!";
        }

        switch (userChoice.toLowerCase()) {
            case "rock":
                return (computerChoice.equals(Scissors)) ? "You win!" : "You lose!";
            case "paper":
                return (computerChoice.equals(Rock)) ? "You win!" : "You lose!";
            case "scissors":
                return (computerChoice.equals(Paper)) ? "You win!" : "You lose!";
            default:
                return "Invalid choice!";
        }
    }

    // Hover Effect for Buttons
    private static void setupHoverEffect(JButton button) {
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.CYAN);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }
        });
    }
}
