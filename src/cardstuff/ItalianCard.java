/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstuff;

/**
 *
 * @author 348676487
 */
public class ItalianCard extends Card {

    //Suit
    public final static int SWORDS = 0;   // Codes for the 4 suits, plus Joker.
    public final static int CUPS = 1;
    public final static int COINS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public static int KNAVE = 8;      // Codes for the non-numeric cards.
    public final static int KNIGHT = 9;    //   Cards 2 through 10 have their 
    public final static int KING = 10;   //   numerical values for their codes.

    /**
     * Creates a default card (Ace of Swords)
     */
    public ItalianCard() {
        setSuit(SWORDS);
        setValue(1);
    }

    /**
     * Creates a card with a specified suit and value.
     *
     * @param theValue the value of the new card.
     * @param theSuit the suit of the new card. This must be one of the values
     * Card.SWORDS, Card.CUPS, Card.COINS, Card.CLUBS
     * @throws IllegalArgumentException if the parameter values are not in the
     * permissible ranges
     */
    public ItalianCard(int theValue, int theSuit) {
        if (theSuit != SWORDS && theSuit != CUPS && theSuit != COINS
                && theSuit != CLUBS && theSuit != JOKER) {
            throw new IllegalArgumentException("Illegal playing card suit");
        }
        if (theValue < 1 || theValue > 10) {
            throw new IllegalArgumentException("Illegal playing card value");
        }
        setValue(theValue);
        setSuit(theSuit);
    }

    /**
     * Returns a String representation of the card's suit.
     *
     * @return one of the strings "Swords", "Cups", "Coins", "Clubs" or "Joker".
     */
    @Override
    public String getSuitAsString() {
        switch (getSuit()) {
            case SWORDS:
                return "Swords";
            case CUPS:
                return "Cups";
            case COINS:
                return "Coins";
            case CLUBS:
                return "Clubs";
            default:
                return "Joker";
        }
    }

    /**
     * Returns a String representation of the card's value.
     *
     * @return for a regular card, one of the strings "Ace", "2", "3", ..., "7",
     * "Knave", "Knight", or "King". For a Joker, the string is always
     * numerical.
     */
    @Override
    public String getValueAsString() {
        switch (getValue()) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "Knave";
            case 9:
                return "Knight";
            default:
                return "King";
        }
    }

    /**
     * Returns a String representation of the card's value and suit
     *
     * @return the value and suit of a card as a string
     */
    @Override
    public String toString() {
        if (this.getSuit() == 4) {
            return ("Joker");
        } else {
            return this.getValueAsString() + " of " + this.getSuitAsString();
        }
    }

}
