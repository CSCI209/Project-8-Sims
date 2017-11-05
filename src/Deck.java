import java.util.*;
import javax.swing.*;

/**
 * Represents a deck of playing cards.
 * @author Shep Sims & klambert
 *
 */
public class Deck{

    private List<Card> deck;

    /**
     * Creates a new deck with 52 cards in random order.
     */
    public Deck(){
	deck = new ArrayList<Card>();
	addSuit(Suit.spade);
	addSuit(Suit.heart);
	addSuit(Suit.diamond);
	addSuit(Suit.club);
	shuffle();
    }

    private void addSuit(Suit suit){
	for (int i = 1; i <= 13; i++)
	    deck.add(new Card(suit, i));
    }

    /**
     * Tests the deck for emptiness.
     * @return true if the deck is empty
     */
    public boolean isEmpty(){
	return deck.size() == 0;
    }

    /**
     * Removes and returns the card at the top of the deck.
     * @return the topmost card
     * @throws IllegalStateException if the deck is empty
     */
    public Card deal(){
	if (isEmpty())
	    throw new IllegalStateException("Deck is empty");
	else
	    return deck.remove(deck.size() - 1);
    }

    /**
     * Arranges the deck's cards in random order.
     */
    public void shuffle(){
	Collections.shuffle(deck);
    }

    /**
     * Returns the string representation of the deck's cards.
     * @return the string representations of the deck's cards
     */
    public String toString(){
	String result = "";
	for (Card c : deck)
	    result += c + "\n";
	return result;
    }
}
