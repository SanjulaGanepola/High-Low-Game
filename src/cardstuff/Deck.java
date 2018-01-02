/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstuff;

/**
 * An object of type Deck represents a deck of playing cards. The deck is a
 * regular poker deck that contains 52 regular cards and that can also
 * optionally include two Jokers.
 */
public class Deck {

    /**
     * An array of 52 cards.
     */
    public FrenchCard[] deck;

    private int numCards = 52;

    /**
     * Keeps track of the number of cards that have been dealt from the deck so
     * far.
     */
    private int cardsUsed;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return deck.length;
    }

    @Override
    public String toString() {
        return this.getSize() + " pack of " + this.getName();
    }

    /**
     * Constructs a regular 52-card poker deck. Initially, the cards are in a
     * sorted order. The shuffle() method can be called to randomize the order.
     *
     * @param jokers
     */
    public Deck(int jokers) {
        //Create a deck array of 52 cards and jokers if the players wants them
        deck = new FrenchCard[52 + jokers];
        int cardCt = 0; // How many cards have been created so far.
        //Fill the deck array with all 52 cards
        for (int value = 1; value <= 13; value++) {
            for (int suit = 0; suit <= 3; suit++) {
                deck[cardCt] = new FrenchCard(value, suit);
                cardCt++;
            }
        }

        //Change the value of ace to 11 when the player wants it to be
        if (FrenchCard.ACE == 11) {
            //Loop through the first four cards
            for (int position = 0; position <= 3; position++) {
                //Change the ace's value to 11
                deck[position] = new FrenchCard(11, position);
                //Make the card know its an ace and not a jack
                deck[position].typeOfCard = true;
            }
        }

        //Add jokers based on how many the player wanted
        if (jokers >= 1) {
            //Add one joker
            deck[52] = new FrenchCard(1, 4);
            if (jokers == 2) {
                //Add a second joekr
                deck[53] = new FrenchCard(1, 4);
            }
        }
        cardsUsed = 0;
    }

    /**
     * Put all the used cards back into the deck (if any), and shuffle the deck
     * into a random order.
     */
    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            FrenchCard temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    /**
     * As cards are dealt from the deck, the number of cards left decreases.
     * This function returns the number of cards that are still left in the
     * deck. The return value would be 52 or 54 (depending on whether the deck
     * includes Jokers) when the deck is first created or after the deck has
     * been shuffled. It decreases by 1 each time the dealCard() method is
     * called.
     */
    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    /**
     * Removes the next card from the deck and return it. It is illegal to call
     * this method if there are no more cards in the deck. You can check the
     * number of cards remaining by calling the cardsLeft() function.
     *
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public FrenchCard dealCard() {
        if (cardsUsed == deck.length) {
            throw new IllegalStateException("No cards are left in the deck.");
        }
        cardsUsed++;
        return deck[cardsUsed - 1];
        // Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.
    }

    /**
     * Test whether the deck contains Jokers.
     *
     * @return true, if this is a 54-card deck containing two jokers, or false
     * if this is a 52 card deck that contains no jokers.
     */
    public boolean hasJokers() {
        return (deck.length == 54);
    }

} // end class Deck
