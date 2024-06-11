import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project7567 extends JFrame {
    private JLabel questionLabel;
    private JLabel headingLabel;
    private JLabel textLabel;
    private JTextField answerField;
    private JButton submitButton;
    private int score;

    private String[][] questions = {
        {"What is the name of the Java compiler?", "javac"},
        {"Which keyword is used to define a method that does not return any value in Java?", "void"},
        {"Which Java keyword is used to define a subclass of a class?", "extend"},
        {"Dancing Java program is known as?", "swing"},
        {"What is the name of the method that gets automatically invoked when an object is created?", "constructor"},
        {"What do you call a group of Java developers?", "array"},
        {"What is JVM?", "platform"},
        {"What is the process of combining multiple classes into one called?", "inheritance"},
        {"Which keyword is used to handle exceptions in Java?", "try"},
        {"What is the keyword used to declare a variable that won't change its value?", "final"}
    };

    private int currentQuestionIndex;

    public Project7567() {
        super("Quiz");

        headingLabel = new JLabel("Welcome to the Quiz");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));

        questionLabel = new JLabel();

        answerField = new JTextField(20);

        submitButton = new JButton("Submit");

        textLabel = new JLabel("Done By J. Yashwanth Reddy, R. SaiGanesh, Y. MohanaLaxmi");
        textLabel.setFont(new Font("Times New Roman", Font.ITALIC, 10));

        score = 0;
        currentQuestionIndex = 0;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(headingLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(questionLabel, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(answerField, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(textLabel, gbc);

        add(panel);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex][0]);
            answerField.setText("");
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText();
        if (userAnswer.equalsIgnoreCase(questions[currentQuestionIndex][1])) {
            score++;
        }
        currentQuestionIndex++;
        showNextQuestion();
    }

    private void showResult() {
        double percentage = (score / (double) questions.length) * 100;
        JOptionPane.showMessageDialog(this, "You got " + score + " questions correct\n" +
                "You got " + percentage + "%");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Project7567();
            }
        });
    }
}
