# 🪨 Rock Paper Scissors – Java GUI Game

A simple yet elegant **Rock, Paper & Scissors** game built using **Java Swing**.  
This project demonstrates GUI programming concepts like event handling, layout management, image rendering, and component layering.

---

## 🎮 Features

✅ Interactive buttons with hover effects  
✅ Dynamic score tracking (User vs Computer vs Draws)  
✅ Beautiful background image  
✅ Smooth gameplay using Randomized computer choices  
✅ Reset functionality  
✅ Clean UI built with `JFrame`, `JLabel`, and `JButton`

---

## ⚙️ Tech Stack

| Component | Description |
|------------|--------------|
| **Language** | Java (JDK 17 or higher recommended) |
| **GUI Library** | Swing (javax.swing) |
| **Logic** | Random number-based AI |
| **Image Rendering** | ImageIcon with scaling |

---

## 📦 Project Setup

### 1️⃣ Clone or Download
```bash
Steps to compile code:
git clone https://github.com/<your-username>/RPS-Game.git
cd java-mini-project
ImageIcon image1 = new ImageIcon("/Users/yourname/Downloads/RPS.png"); -- change the image path if needed
java --version
javac RPS.java
java RPS



Important Question & Answers:

🎯 Rock Paper Scissors — Viva Questionnaire
🧩 Basic Questions

Q: What is the purpose of this Java project?
A: The project is a GUI-based Rock, Paper, Scissors game built using Java Swing, where a user plays against the computer.

Q: What does the main method do in this program?
A: The main method acts as the entry point of the program and initializes all game components like buttons, labels, and event listeners.

Q: What is a JFrame?
A: JFrame is the main window of the application that holds all other components such as labels, buttons, and images.

Q: What is the role of JButton in this project?
A: JButton is used for the Rock, Paper, and Scissors options, allowing the user to interact with the game by clicking.

Q: Why do we use JLabel in the project?
A: JLabel displays text or images on the screen, such as the current score, result, and background image.

⚙️ Intermediate Questions

Q: How does the game determine the computer’s choice?
A: The program uses Java’s Random class to generate a random integer between 0 and 2, representing Rock (0), Paper (1), or Scissors (2).

Q: What is the use of ActionListener in this game?
A: ActionListener detects button clicks and triggers the game logic defined in the actionPerformed() method.

Q: What is the purpose of setLayout(null)?
A: It disables the default layout manager so we can manually position each component using setBounds().

Q: How are images displayed in this game?
A: Images are displayed using ImageIcon, which is added to a JLabel and set as the background of the JFrame.

Q: How does the score update after each round?
A: When the user or computer wins, their respective score variable increments, and scoreLabel.setText() updates the score display on screen.

🧠 Logic & Flow Questions

Q: What logic is used to decide the winner?
A: The logic compares the user’s choice and the computer’s choice:

if (user == comp) → Draw  
else if ((user == 0 && comp == 2) || (user == 1 && comp == 0) || (user == 2 && comp == 1)) → User Wins  
else → Computer Wins


Q: Why are Rock, Paper, and Scissors represented as 0, 1, and 2?
A: It simplifies comparison logic using integers instead of strings, making conditions shorter and faster.

Q: What is the role of the reset button?
A: It resets both the user and computer scores to zero and updates the display labels to start a new game.

Q: How does the background image stay behind all components?
A: The image label (imagelabel1) is added to the frame first, and other UI components are added afterward, so they appear above it.

Q: What happens when both the user and computer choose the same option?
A: The result label displays “It’s a Draw!”, and no score is changed.

💡 Advanced Questions

Q: What happens if frame.setVisible(true) is not called?
A: The window and all its components will not be displayed on the screen.

Q: Why is setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) used?
A: It ensures that the program terminates properly when the window is closed.

Q: Can multiple buttons share the same ActionListener?
A: Yes, all buttons share the same ActionListener, and we differentiate them using if (e.getSource() == buttonName) inside actionPerformed().

Q: How can the game be extended to stop after 5 rounds?
A: By adding a round counter and checking after each click:

if (roundCount == 5) {
    showFinalWinner();
    resetGame();
}


Q: How can we improve this project further?
A: Possible improvements include:

Adding sound effects for wins/losses

Displaying icons for Rock, Paper, and Scissors instead of text

Showing final results in a pop-up dialog

Saving scores persistently to a file or database
