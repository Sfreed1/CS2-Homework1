import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame{
    /**
     * The random number generator.  DO NOT CHANGE
     */
    public static Random randomNumber = new Random();

    /**
     * Scanner to get user input.  DO NOT CHANGE
     */
    public static Scanner input = new Scanner(System.in);

    /**
     * Asks user if they want to play
     * 
     * @return True if player wants to play again
     */
    public static boolean wantToPlayAgain(){
        Boolean bool = false;
        while(!bool){
            System.out.println("Would you like to play again (y/n)?");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("y")){
                return true;
            }else if (answer.equalsIgnoreCase("n")){
                return false;
            }
        }
        return true;
    }

    /**
     * Generates new random number between 1 and 100
     * 
     * @return new secret number
     */
    public static int generateSecretNumber(){
        int num = randomNumber.nextInt(100) + 1;
        return num;
    }

    /**
     * Play one iteration of the game.  This method creates a new secret number
     * and prompts the user to keep guessing until the guess is correct.
     * 
     * The user is prompted for a number and you need to read in the next input (hint: use the Scanner).
     * It should use isGuessValid, isQuit, checkGuess, and generateSecretNumber.
     * 
     * @return False if the user quits
     */
    public static boolean playOneGame(){
        int num = generateSecretNumber();
        int counter = 0;
        Boolean bool = false;
        while (!bool){
            //gets input from user. guessNum changes input into an int
            System.out.println("Please enter a number from 1 to 100 (or q to quit):");
            String guess = input.nextLine();
            
            if (isQuit(guess)){
                return false;
            }

            try{
                int guessNum = Integer.parseInt(guess);
                
                if (guessNum > 0 && guessNum < 101){
                    if (checkGuess(num, guessNum)){
                        bool = true;
                        System.out.println("That's correct.  It took you " + counter + " guesses");
                        return true;
                    }
                }
                counter++;
            } catch (NumberFormatException ime){
                System.out.println("That's not a valid input!");
            }
            
        }
        return true;
    }


    /**
     * Check whether guess is correct or not and report whether it is too high or too low.
     * This assumes that the guess has been confirmed to be valid.
     * 
     * If too high, prints 'too high' and returns false
     * If too low, prints 'too low' and returns false
     * 
     * @param mysteryNumber the secret number that the user is trying to guess
     * @param guess the user's guess 
     * @return True if the guess is correct
     */
    public static boolean checkGuess(int mysteryNumber, int guess){
            if (guess < mysteryNumber){
                System.out.println("Incorrect, too low");
                return false;
            } else if (guess > mysteryNumber){
                System.out.println("Incorrect, too high");
                return false;
            }else{
                return true;
            }
    }

    /**
     * Checks if the player's input indiates they want to quit.
     * @param guess
     * @return True if input is "q" or "Q"
     */
    public static boolean isQuit(String guess){
        if (guess.equalsIgnoreCase("q")){
            System.out.println("bye");
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args){
        Boolean playAgain = false;
        while(!playAgain){
            if(playOneGame()){
                if (!wantToPlayAgain()){
                    playAgain = true;
                }
            }else{
                playAgain = true;
            }
        }
    }
}