package logic;

import data.Answer;
import data.CountryDetails;
import lombok.Getter;
import lombok.Setter;
import ui.Toast;

import java.util.ArrayList;

@Getter
@Setter
public class Game {
    private ArrayList<String> names;
    private int questionCounter;
    private Question currentQuestion;
    private int numberOfQuestions;
    private int correctAnswers;
    private int wrongAnswers;

    public Game() {
        questionCounter = 1;
        correctAnswers = 0;
        wrongAnswers = 0;
    }

    public void loadQuestion() throws NullPointerException {
        CountryDetails countryDetails = LogLoader.getNextCountryDetails();
        currentQuestion = new Question(countryDetails);
    }

    public boolean checkAnswer(Answer answer) {
        boolean result = answer == currentQuestion.getCorrectAns();
        if (result) correctAnswers++;
        else wrongAnswers++;
        questionCounter++;
        return result;
    }

    public void nextQuestion(int x, int y, int height) {
        do {
            try {
                this.loadQuestion();
            } catch (Exception exp) {
                this.setQuestionCounter(this.getQuestionCounter() + 1);
                Toast toast = new Toast(LogLoader.currentCode + " doesn't exist", x + 8, y + height - 80, false);
                toast.start();
                try { Thread.sleep(1000); }
                catch (InterruptedException e) { e.printStackTrace(); }
                this.setCurrentQuestion(null);
            }
        } while (this.getCurrentQuestion() == null);
    }
}
