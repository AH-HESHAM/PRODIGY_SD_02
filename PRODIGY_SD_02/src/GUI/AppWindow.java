package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import GuessingGame.GuessingGame;

public class AppWindow extends JFrame implements ActionListener {
    private JLabel mainTitle, inputGuide, ans;
    private JTextArea guessBox;
    private JButton guessButton;
    GuessingGame gameEngine;

    public void showWindow(GuessingGame gameEngine) {
        this.gameEngine = gameEngine;
        setWindowSettings();
        CreateComponents();
        setLayout(null);
        addComponents();
        adjustPostions();
        adjustFonts();
    }

    private void setWindowSettings() {
        setTitle("Guessing Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void CreateComponents() {
        mainTitle = new JLabel("Guessing Game");
        inputGuide = new JLabel("Guess the number between 0 and 1,000,000");

        guessBox = new JTextArea();
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);

        ans = new JLabel("");
    }

    private void addComponents() {
        add(mainTitle);
        add(inputGuide);
        add(ans);
        add(guessBox);
        add(guessButton);
    }

    private void adjustPostions() {
        mainTitle.setBounds(190, 10, 500, 50);
        inputGuide.setBounds(90, 65, 500, 50);
        guessBox.setBounds(250, 120, 100, 40);
        guessButton.setBounds(250, 175, 100, 30);
        ans.setBounds(20, 200, 500, 50);
    }

    private void adjustFonts() {
        mainTitle.setFont(new Font("Serif", Font.BOLD, 30));
        inputGuide.setFont(new Font("Serif", Font.PLAIN, 25));
        guessBox.setFont(new Font("Serif", Font.PLAIN, 25));
        guessButton.setFont(new Font("Serif", Font.PLAIN, 20));
        ans.setFont(new Font("Serif", Font.PLAIN, 20));
        Color windowColor = new Color(51, 153, 255);
        this.getContentPane().setBackground(windowColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            try {
                ans.setText(guess());
            } catch (Exception exception) {
                ans.setText("Invalid data entered");
            }
        }
    }

    private String guess() {
        int playerGuess = Integer.parseInt(guessBox.getText());
        return gameEngine.guess(playerGuess);
    }

}
