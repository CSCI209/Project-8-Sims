/**
 * @author Shep Sims, Peter Blair, Andrew Baca, Trip Calihan
 * File: Cell.java
 * Creates an abstract interface 
 */

public interface Cell extends Iterable<Card>
{
	/**
	 * Determines whether the card can be added from the pile
	 * @return true if it meets the conditions or false otherwise
	 */
  public boolean canAddFrom(Cell paramCell);
  
  
  public void add(Card paramCard);
  
  public boolean addFrom(Cell paramCell);
  
  public void clear();
  
  public Card remove();
  
  public Card remove(int paramInt);
  
  public Card get(int paramInt);
  
  public int size();
  
  public boolean isEmpty();
  
  public boolean inOrder();
  
  public Card seeTop();
  
  /**
   * Determines if cell "c" is an instance of HomeCell
   * @return true if it is or otherwise false
   */
  public boolean isHomeCell(Cell c);
}
