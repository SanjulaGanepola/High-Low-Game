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
public abstract class Card {

    /**
     * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS, CLUBS,
     * or JOKER. The suit cannot be changed after the card is constructed.
     */
    private int suit;

    /**
     * The card's value. For a normal card, this is one of the values 1 through
     * 13, with 1 representing ACE (for French cards). For Italian cards, the
     * values range from 1 to 10. For a JOKER, the value can be anything. The
     * value cannot be changed after the card is constructed.
     */
    private int value;

    /**
     * Returns the suit of this card.
     *
     * @returns the suit, which is one of the constants Card.SPADES,
     * Card.HEARTS, Card.DIAMONDS, Card.CLUBS
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the value of this card.
     *
     * @return the value, which is one of the numbers 1 through 13, inclusive
     * for a regular card
     */
    public int getValue() {
        return value;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns a String representation of the card's suit.
     *
     * @return the suit of a card
     */
    abstract public String getSuitAsString();

    /**
     * Returns a String representation of the card's value.
     *
     * @return the value of a card
     */
    abstract public String getValueAsString();

    /**
     * Returns a String representation of the card's value and suit
     *
     * @return the value and suit of a card as a string
     */
    @Override
    abstract public String toString();
}
