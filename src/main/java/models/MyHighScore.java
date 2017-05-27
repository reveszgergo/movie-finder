package models;

/**
 * Egy high score-t reprezentáló osztály.
 */
public class MyHighScore {

	/**
	 * A pontszámot elérő neve.
	 */
	private String name;
	/**
	 * Az elért pontszám.
	 */
	private String point;
	
	/**
	 * Visszaadja a pontszámot elérőnek a nevét.
	 * 
	 * @return a pontszámot elérő neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Módosítja a pontszámot elérőnek a nevét.
	 * 
	 * @param name az a {@code String}, ami az új név lesz
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja az elért pontszámot.
	 * 
	 * @return az elért pontszám
	 */
	public String getPoint() {
		return point;
	}
	
	/**
	 * Módosítja a pontszámot.
	 * 
	 * @param point az a {@code String}, ami az új pont lesz
	 */
	public void setPoint(String point) {
		this.point = point;
	}
	
}
