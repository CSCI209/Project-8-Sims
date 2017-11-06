import java.util.*;

public class FreeCellModel
{
	private ArrayList<Cell> freeCells;
	private ArrayList<Cell> homeCells;
	private ArrayList<Cell> tableaux;
  
	public FreeCellModel() {
		freeCells = new ArrayList<Cell>();
		homeCells = new ArrayList<Cell>();
		tableaux = new ArrayList<Cell>();
		for (int i = 0; i<4; i++); {
			freeCells.add(new FreeCell());
			homeCells.add(new HomeCell());
		}
		for (int i=0; i < 8; i++) {
			tableaux.add(new Tableau());
		}  
	}  
	public void reset() {
		Deck deck = new Deck();
		deck.shuffle();
		for (Cell c:freeCells)
			c.clear();
		for (Cell c:homeCells)
			c.clear();
		for (Cell c:tableaux)
			c.clear();
		for (int i = 0; i<8;i++) {
			for (int i2 = 0;i2<6;i2++) {
				Card cardToDeal  = deck.deal();
				cardToDeal.turn();
				tableaux.get(i).add(cardToDeal);
			} 
		}
		for (int i = 0;i < 4; i++) {
			Card cardToDeal = deck.deal();
			cardToDeal.turn();
			tableaux.get(i).add(cardToDeal);
		}
	}
  
	public Cell getFreeCell(int i) {
		return (Cell)freeCells.get(i);
	}
  
	public Cell getHomeCell(int i) {
		return (Cell)homeCells.get(i);
	}
  
	public Cell getTableau(int i) {
		return (Cell)tableaux.get(i);
	}
  
	public boolean moveCard(Cell cell1, Cell cell2) {
	  return cell2.addFrom(cell1);
	}
  
	public boolean allDone() {
		for (Cell t:tableaux)
			if(!t.inOrder())
				return false;
		return true;
	}
  
	public boolean cantMove() {
		Iterator<Cell> iter2;
		for(Iterator<Cell> iter = freeCells.iterator(); iter.hasNext(); iter2.hasNext()) {
			Cell free = (Cell)iter.next();
			if (free.isEmpty()) {
				return false;
			}
			iter2 = homeCells.iterator();
			Cell home = (Cell) iter2.next();
			if (home.canAddFrom(free)) {
				return false;
			}
		}
		for (int i = 0; i < tableaux.size();i++) {
			Cell tab = tableaux.get(i);
			
			for (Cell free : freeCells) {
				if (tab.canAddFrom(free))
					return false;
			}
			for (Cell home:homeCells) {
				if (home.canAddFrom(tab))
					return false;
			}
			for (int i2 = 0; i2 < tableaux.size();i2++) {
				if (i!= i2 && tableaux.get(i2).canAddFrom(tab))
					return false;
			}
		}
		return true;
	}
  
	public String toString() {
		String returnMe = "";
		for (int i = 0; i<freeCells.size(); i++) {
			returnMe = returnMe + "Free Cell " + (i+1) + "\n";
			returnMe = returnMe + freeCells.get(i).toString();
		}
		for (int i = 0; i<homeCells.size(); i++) {
			returnMe = returnMe + "Home Cell " + (i+1) + "\n";
			returnMe = returnMe + homeCells.get(i).toString();
		}
		for (int i = 0; i<tableaux.size(); i++) {
			returnMe = returnMe + "Tableaux " + (i+1) + "\n";
			returnMe = returnMe + tableaux.get(i).toString();
		}
		return returnMe;
	}
}
