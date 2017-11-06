import javax.swing.*;

/**
 * Represents a playing card with a suit,
 * rank, image, and face up status.
 * @author Trip Calihan, Peter Blair, Shep Sims, Andrew Bacca
 *
 */
public class Card implements Comparable<Card>{

    private Suit suit;
    private int rank;
    private boolean faceUp;
    private Icon image;
    private static Icon CARD_BACK;
    private String color;

    /**
     * Constructor.
     * @param suit the card's suit
     * @param rank the card's rank
     * @param color the card's color
     */
    public Card(Suit suit, int rank){
    	this.suit = suit;
    	this.rank = rank;
    	faceUp = false;
    	image = getImageFromFile(rank, suit);
    	if (CARD_BACK == null)
    		CARD_BACK = getBackFromFile();
    	if ((suit.equals(Suit.diamond)) || (suit.equals(Suit.heart))) {
    		this.color = "red";
    	}
    	else
    		this.color = "black";
    	}

    /**
     * Returns the card's face image if its face is up or its back side image otherwise.
     * @return the card's face image or the back side image
     */
    public Icon getImage(){
    	if (faceUp)
    	    return image;
    	else
    	    return CARD_BACK;
    }

    /**
     * Returns the back side image of a card.
     * @return the back side image of a card
     */
    public static Icon getBack(){
    	if (CARD_BACK == null)
    	    new Card(Suit.spade, 1);
    	return CARD_BACK;
    }

    /**
     * Turns the card over, negating its face up status.
     */
    public void turn(){
    	faceUp = ! faceUp;
    }

    private Icon getImageFromFile(int rank, Suit suit){
    	String fileName = "DECK/";
    	fileName += rank;
    	fileName += Character.toUpperCase(suit.toString().charAt(0));
    	fileName += ".GIF";
    	return new ImageIcon(getClass().getResource(fileName));
    }

    private Icon getBackFromFile(){
    	String fileName = "DECK/CARDBACK.GIF";
    	return new ImageIcon(getClass().getResource(fileName));
    }

    /**
     * Returns the card's face up status.
     * @return true if face up or false otherwise
     */
    public boolean isFaceUp(){
       return faceUp;
    }

    /**
     * Returns the card's suit.
     * @return the card's suit
     */
    public Suit getSuit(){
        return suit;
    }

    /**
     * Returns the card's rank
     * @return the card's rank
     */
    public int getRank(){
        return rank;
    }

    /**
     * Compares two cards with respect to rank
     * @return 0 if equal, less than 0 if less, greater than 0 if greater
     */
    public int compareTo(Card other){
        return this.rank - other.rank;
    }

    /**
     * Returns the string representation of the card (rank of suit)
     * @return the string representation of the card
     */
    public String toString(){
        return rankToString(rank) + " of " + suit;
    }

    static private String rankToString(int rank){
        if (rank >= 2 && rank <= 10) return rank + "";
        else if (rank == 11) return "Jack";
        else if (rank == 12) return "Queen";
        else if (rank == 13) return "King";
        else return "Ace";
    }
    
    /**
     * Compares two cards for value differential
     * @return true if the difference in card values is 1 or false otherwise
     */
    public boolean oneLarger(Card other) {
    		return rank - other.getRank() == 1;
    }
    
    /**
     * Compares two cards to identify if they have the same color
     * @return true if the cards are the same color or false otherwise
     */
    public boolean sameColor(Card other) {
    		return color.equals(color);
    }
    
    /**
     * Compares two cards to identify if they are of the same suit
     * @return true if the cards are the same suit or false otherwise
     */
    public boolean sameSuit(Card other) {
    		return suit.equals(other.getSuit());
    }
    
}