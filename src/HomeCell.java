/**
 * @author Shep Sims, Andrew Baca, Trip Calihan, Peter Blair
 * File: HomeCell.java
 * HomeCell, a subclass, extends AbstractCell
 */
public class HomeCell extends AbstractCell
{
	/**
	 * Calls method from AbstractCell
	 */
	public HomeCell() {
			super(13);
	}
	
	/**
	 * Determines if the conditions are met for adding a card from cell c
	 * @param c
	 * @return false if the following conditions are not met, which determine whether a card can be added,
	 * otherwise it returns true, indicating that it can be added
	 */
	public boolean canAddFrom(Cell c) {
		
		if (super.canAddFrom(c)) {
			return true;
		}
		
		Card topCard = c.seeTop();
		if (c.isEmpty()) {
			if (topCard.getRank()!=1) {
				return false;
			}
			return true;
		}
		Card bottomCard = seeTop();
		if ((topCard.sameSuit(bottomCard)) && (topCard.oneLarger(bottomCard)))
			return true;
		else
			return false;
	}
}