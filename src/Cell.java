/**
 * @author Shep Sims, Peter Blair, Andrew Baca, Trip Calihan
 * File: Cell.java
 * 
 * Creates an abstract interface for cells.
 * 
 */

public interface Cell extends Iterable<Card>
{
  /**
   * Determines whether the card can be added from the pile.
   * @param the cell to check.
   * @return true if it meets the conditions or false otherwise.
   */
  public boolean canAddFrom(Cell paramCell);
  
  /**
   * Adds card to top of cell.
   * @param the card to add.
   */
  public void add(Card paramCard);
  
  /**
	 * Adds the cards from Cell "c" if canAddFrom is true
	 * @param The cell to add cards from
	 * @return true if the cards are added or otherwise false
	 */
  public boolean addFrom(Cell paramCell);
  
  /**
   * Clears cell of contents.
   */
  public void clear();
  
  /**
   * Removes topmost card from cell and returns it.
   * @return removed card.
   */
  public Card remove();
  
  /**
   * Removes card at index from cell and returns it.
   * @param int i, for card's point index in cell.
   * @return removed card.
   */
  public Card remove(int paramInt);
  
  /**
   * Returns card at index from cell.
   * @param int i, for card's point index in cell.
   * @return indexed card.
   */  
  public Card get(int paramInt);
  
  /**
   * Returns length of cell as an int.
   * @return int length of cell.
   */
  public int size();
  
  /**
   * Checks if cell has contents, returns boolean.
   * @return boolean, true if cell has no contents, false if not.
   */
  public boolean isEmpty();
  
  /**
   * Checks if cell's contents are in order, returns boolean.
   * @return boolean, true if cell's contents are in order, false if not.
   */
  public boolean inOrder();
  
  /**
   * Returns topmost card in cell.
   * @return topmost Card in cell.
   */
  public Card seeTop();
  
  /**
   * Determines if cell "c" is an instance of HomeCell
   * @return true if it is or otherwise false
   */
    public boolean isHomeCell(Cell c);
}
