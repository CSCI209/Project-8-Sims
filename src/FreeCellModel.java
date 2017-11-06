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

	}
  
	public boolean cantMove() {
    
	}
  
	public String toString() {
	}
}
