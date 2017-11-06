import java.util.Iterator;

/**
 * @author Shep Sims, Peter Blair, Andrew Baca, Trip Calihan
 * File: Cell.java
 * Creates an abstract interface 
 */

public abstract interface Cell
{
  public abstract boolean canAddFrom(Cell paramCell);
  
  public abstract void add(Card paramCard);
  
  public abstract boolean addFrom(Cell paramCell);
  
  public abstract void clear();
  
  public abstract Card remove();
  
  public abstract Card remove(int paramInt);
  
  public abstract Card get(int paramInt);
  
  public abstract int size();
  
  public abstract boolean isEmpty();
  
  public abstract boolean inOrder();
  
  public abstract Card seeTop();
  
  public abstract Iterator<Card> iterator();
  
  public abstract String toString();
  
  public abstract boolean isHomeCell(Cell c);
  
  public abstract boolean isFreeCell(Cell c);
  
  public abstract boolean isTableau(Cell c);
}
