package ui;

import bundles.IBundle;
import data.Answer;
import logic.Game;
import logic.Question;
import preferences.LanguagePreferences;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GameGUI extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel mainPanel;
    private JButton buttonA;
    private JLabel question;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton checkButton;
    private JProgressBar progressBarGame;
    private JLabel progressLabel;
    private JLabel questionLabel;
    private JComboBox<String> languageBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Answer selectedAnswer;
    private IBundle bundle;
    private final Game game;

    public GameGUI(Game game, IBundle bundle, int selectedLanguage) {
        initComponents();
        this.game = game;
        this.bundle = bundle;
        iniGame(selectedLanguage);

        languageBox.addItemListener(e -> {
            changeBundle();
            setupLanguage();
        });

        buttonA.addActionListener(e -> {
            resetButtons(Answer.A);
            buttonA.setBackground(new java.awt.Color(10, 152, 162));
        });

        buttonB.addActionListener(e -> {
            resetButtons(Answer.B);
            buttonB.setBackground(new java.awt.Color(10, 152, 162));
        });

        buttonC.addActionListener(e -> {
            resetButtons(Answer.C);
            buttonC.setBackground(new java.awt.Color(10, 152, 162));
        });

        buttonD.addActionListener(e -> {
            resetButtons(Answer.D);
            buttonD.setBackground(new Color(10, 152, 162));
        });

        checkButton.addActionListener(e -> {
            progressBarGame.setValue(game.getQuestionCounter());
            showToast();

            if (game.getQuestionCounter() != game.getNumberOfQuestions() + 1)
                game.nextQuestion(this.getX(), this.getY(), this.getHeight());

            resetButtons(null);
            displayQuestion(game.getCurrentQuestion());

            if (game.getQuestionCounter() == game.getNumberOfQuestions() + 1)
                endGame();
        });

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void resetButtons(Answer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
        buttonA.setBackground(Color.darkGray);
        buttonB.setBackground(Color.darkGray);
        buttonC.setBackground(Color.darkGray);
        buttonD.setBackground(Color.darkGray);
        checkButton.setEnabled(true);
    }

    private void endGame() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        Toast end = new Toast(bundle.getString("EndGame"), this.getX() + 8, this.getY() + this.getHeight() - 80, true);
        end.start();
        new Results(game.getCorrectAnswers(), game.getWrongAnswers());
    }

    private void showToast() {
        Toast toast;
        Question currentQuestion = game.getCurrentQuestion();
        if (game.checkAnswer(selectedAnswer)) {
            String message = bundle.getResponse(currentQuestion.getCountry(), true, currentQuestion.getCorrectAnswer());
            toast = new Toast(message, this.getX() + 8, this.getY() + this.getHeight() - 50, true);
        } else {
            String message = bundle.getResponse(currentQuestion.getCountry(), false, currentQuestion.getCorrectAnswer());
            toast = new Toast(message, this.getX() + 8, this.getY() + this.getHeight() - 50, false);
        }
        toast.start();
    }

    private void changeBundle() {
        String selected = languageBox.getSelectedItem().toString();
        Locale locale = new Locale(selected.toLowerCase(), selected);
        bundle = (IBundle) ResourceBundle.getBundle("bundles.Bundle", locale);
        LanguagePreferences.setPreferences(selected);
    }

    private void setupLanguage() {
        checkButton.setText(bundle.getString("Check"));
        progressLabel.setText(bundle.getString("Progress"));
        question.setText(bundle.getString("Question"));
        questionLabel.setText(bundle.getQuestion(game.getCurrentQuestion().getCountry()));
    }

    private void displayQuestion(Question question) {
        ArrayList<Integer> answers = question.getAnswers();
        buttonA.setText(answers.get(0).toString());
        buttonB.setText(answers.get(1).toString());
        buttonC.setText(answers.get(2).toString());
        buttonD.setText(answers.get(3).toString());
        questionLabel.setText(bundle.getQuestion(question.getCountry()));
    }

    private void iniGame(int selectedLanguage) {
        progressBarGame.setMaximum(game.getNumberOfQuestions());
        game.nextQuestion(this.getX(), this.getY(), this.getHeight());
        displayQuestion(game.getCurrentQuestion());
        languageBox.addItem("EN");
        languageBox.addItem("PL");
        languageBox.setSelectedIndex(selectedLanguage);
        setupLanguage();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainPanel = new JPanel();
        buttonA = new JButton();
        question = new JLabel();
        buttonB = new JButton();
        buttonC = new JButton();
        buttonD = new JButton();
        checkButton = new JButton();
        progressBarGame = new JProgressBar();
        progressLabel = new JLabel();
        questionLabel = new JLabel();
        languageBox = new JComboBox<String>();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/appIcon.png")).getImage());
        setResizable(false);
        var contentPane = getContentPane();

        //======== mainPanel ========
        {

            //---- buttonA ----
            buttonA.setText("A");

            //---- question ----
            question.setText("Question: ");

            //---- buttonB ----
            buttonB.setText("B");

            //---- buttonC ----
            buttonC.setText("C");

            //---- buttonD ----
            buttonD.setText("D");

            //---- checkButton ----
            checkButton.setText("check");
            checkButton.setEnabled(false);

            //---- progressLabel ----
            progressLabel.setText("Progres");
            progressLabel.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
            mainPanel.setLayout(mainPanelLayout);
            mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonD, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(question, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(checkButton, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(progressBarGame, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(progressLabel, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(languageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
            );
            mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup()
                                    .addComponent(question, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(languageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonA, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonB, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(progressLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressBarGame, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonD, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
