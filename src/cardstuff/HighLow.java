/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstuff;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This program lets the user play HighLow, a simple card game that is described
 * in the output statements at the beginning of the main() routine. After the
 * user plays several games, the user's average score is reported.
 */
public class HighLow {

    private static double correctGuess = 0;
    private static double gamesPlayed = 0;

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("This program lets you play the simple card game,");
        System.out.println("HighLow.  A card is dealt from a deck of cards.");
        System.out.println("You have to predict whether the next card will be");
        System.out.println("higher or lower.  ");

        Scanner kbScan = new Scanner(System.in);

        //Obtain how many jokers the player wants to play with
        System.out.println("Enter the number of jokers: ");
        int jokers = kbScan.nextInt();

        //Obtain the value of ace
        System.out.println("Enter the value of ace (1 or 11): ");
        FrenchCard.ACE = kbScan.nextInt();

        // Get a new deck of cards, and  store a reference to it in    the variable, deck.
        Deck deck = new Deck(2);

        kbScan.nextLine();

        //Change the name of the deck and output it
        System.out.println("Enter the name of the deck: ");
        deck.setName(kbScan.nextLine());
        System.out.println("Chosen Deck: " + deck.toString());

        // Declare a variable to represent current FrenchCard
        FrenchCard current = new FrenchCard();
        // Declare a variable to represent the next FrenchCard in the deck 
        FrenchCard next = new FrenchCard();
        // Declare a variable to represent the result of the guess (in)correct
        boolean result;
        //Declare a variable to represent the guess 'H' for higher, 'L' for lower
        char guess;

        //Shuffle the deck
        deck.shuffle();

        try {
            while (true) {
                //Deal one card to be the current card
                current = deck.dealCard();
                System.out.println("Current card: " + current.toString());

                //Get guess
                System.out.println("Enter (H or L) to guess if the card is higher or lower: ");
                do {
                    guess = kbScan.nextLine().charAt(0);
                    guess = Character.toUpperCase(guess);
                    if (guess != 'H' && guess != 'L') {
                        System.out.print("Please respond with H or L:  ");
                    }
                } while (guess != 'H' && guess != 'L');

                //Deal another card and show it to user
                next = deck.dealCard();
                System.out.println("Next card: " + next.toString());

                //Output a win if the current or the next card is a joker
                if (next.getSuit() == 4 || current.getSuit() == 4) {
                    System.out.println("WIN");
                    correctGuess++;
                    gamesPlayed++;
                } //Check the prediction and output result
                else {
                    if (next.getValue() > current.getValue()) {
                        System.out.println(check(guess, 'H'));
                    } else if (next.getValue() < current.getValue()) {
                        System.out.println(check(guess, 'L'));
                    } else {
                        if (next.getSuit() < current.getSuit()) {
                            System.out.println(check(guess, 'H'));
                        } else if (next.getSuit() > current.getSuit()) {
                            System.out.println(check(guess, 'L'));
                        } else {
                            System.out.println(check(guess, 'H'));
                        }
                    }
                }// end play()
            }
        } catch (IllegalStateException e) {
            //Output the average score
            System.out.println("End the Game with an Average Score of " + df.format((correctGuess / gamesPlayed) * 100) + "%");
        }
    }

    /**
     * Decide if a guess matches the correct answer. Also keep track of the
     * correct guess and the number of games played.
     *
     * @param guess the prediction inputed based on whether the next card is
     * higher than the current card
     * @param answer the correct answer to whether the next card is higher than
     * the current card
     * @return result of the comparison between the guess and the answer
     */
    public static String check(char guess, char answer) {
        String result;
        //Guess matches the correct answer
        if (guess == answer) {
            result = "WIN";
            correctGuess++;
            gamesPlayed++;
        } 
        //Guess does not match the correct answer
        else {
            result = "LOSE";
            gamesPlayed++;
        }
        return result;
    }
}// end class HighLow

