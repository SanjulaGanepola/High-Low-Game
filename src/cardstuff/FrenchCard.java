/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstuff;

/**
 * An object of type FrenchCard represents a playing card from a standard Poker
 * deck, including Jokers. The card has a suit, which can be spades, hearts,
 * diamonds, clubs, or joker. A spade, heart, diamond, or club has one of the 13
 * values: ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, or king. Note that
 * "ace" is considered to be the smallest value. A joker can also have an
 * associated value; this value can be anything and can be used to keep track of
 * several different jokers.
 */
public class FrenchCard extends Card {

    public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public static int ACE = 1;      // Codes for the non-numeric cards.
    public final static int JACK = 11;    //   Cards 2 through 10 have their 
    public final static int QUEEN = 12;   //   numerical values for their codes.
    public final static int KING = 13;

    //Boolean to keep try of if a card with value 11 is ace or jack
    public boolean typeOfCard = false;

    /**
     * Creates a default card
     */
    public FrenchCard() {
        setSuit(SPADES);
        setValue(1);
    }

    /**
     * Creates a card with a specified suit and value.
     *
     * @param theValue the value of the new card.
     * @param theSuit the suit of the new card. This must be one of the values
     * Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS
     * @throws IllegalArgumentException if the parameter values are not in the
     * permissible ranges
     */
    public FrenchCard(int theValue, int theSuit) {
        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS
                && theSuit != CLUBS && theSuit != JOKER) {
            throw new IllegalArgumentException("Illegal playing card suit");
        }
        if (theValue < 1 || theValue > 13) {
            throw new IllegalArgumentException("Illegal playing card value");
        }
        setValue(theValue);
        setSuit(theSuit);
    }

    /**
     * Returns a String representation of the card's suit.
     *
     * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs" or
     * "Joker".
     */
    @Override
    public String getSuitAsString() {
        switch (getSuit()) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "Joker";

        }
    }

    /**
     * Returns a String representation of the card's value.
     *
     * @return for a regular card, one of the strings "Ace", "2", "3", ...,
     * "10", "Jack", "Queen", or "King". For a Joker, the string is always
     * numerical.
     */
    @Override
    public String getValueAsString() {

        switch (getValue()) {
            case 1:
                return "Ace";
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
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                //Determine if this card with value 11 is either ace or jack
                if (typeOfCard == true) {
                    return "Ace";
                } else {
                    return "Jack";
                }
            case 12:
                return "Queen";
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
} // end class FrenchCard