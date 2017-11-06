public class HomeCell extends AbstractCell
{
	public HomeCell() {
			super(13);
	}
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