package point;

/**
 * A kvíz alatt gyűjtött pontokat összeadó osztály.
 */
public class HighScoreCalculator {

	/**
	 * Az összesített pontszám.
	 */
	private int point;
	
	/**
	 * Visszaadja a szerzett pontokat.
	 * 
	 * @return a szerzett pontok
	 */
	public int getPoint() {
		return point;
	}
	
	/**
	 * Hozzáadja a pontszámhoz a kapott pontot.
	 * 
	 * @param point a hozzáadni kívánt pont
	 */
	public void addPoint(int point){
		this.point += point;
	}
}
