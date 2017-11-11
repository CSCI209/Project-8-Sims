/**
 * @author Shep Sims, Peter Blair, Andrew Baca, Trip Calihan
 * File: Cell.java
 * Creates an abstract interface 
 */

public interface Cell extends Iterable<Card>
{
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
  
  public boolean isHomeCell(Cell c);
}
