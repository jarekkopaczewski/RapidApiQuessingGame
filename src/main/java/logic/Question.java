package logic;

import data.Answer;
import data.CountryDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Question {
    private final ArrayList<Integer> answers;
    private final int correct;
    private final Answer correctAns;
    private Random random = new Random();
    private String country;
    private int correctAnswer;
    private String photoUrl;

    public Question(CountryDetails countryDetails) {
        this.correctAnswer = countryDetails.getNumRegions();
        int temp;
        this.country = countryDetails.getName();
        this.photoUrl = countryDetails.getFlagImageUri();
        answers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            do {
                temp = getRandom((int) (correctAnswer * 0.25f), (int) (correctAnswer * 2f));
            } while (temp == correctAnswer || answers.contains(temp));
            answers.add(temp);
        }
        correct = getRandom(0, 4);
        answers.set(correct, correctAnswer);
        correctAns = Answer.values()[correct];
    }

    public int getRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
