package GuessingGame;

import java.util.Random;

public class GuessingGameImp implements GuessingGame {

    private int correctNumber;
    private int counter;

    public GuessingGameImp(){
        this.correctNumber = generateRandomeNumber();
        this.counter = 0;
    }

    private int generateRandomeNumber(){
        Random rand = new Random();
        return rand.nextInt(1000000);
    }

    @Override
    public String guess(int playerGuess) {
        counter++;
        if(playerGuess > correctNumber)
            return "It's a large number, try a smaller one!";
        
        else if(playerGuess < correctNumber)
            return "It's a small number, try a larger one!";
        
        else
            return "Well Done! you take " + counter + " attempt(s) to guess correctly";
    }
    
}
