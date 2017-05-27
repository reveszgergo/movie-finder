package models;

/**
 * Egy saját értékelést reprezentáló osztály.
 */
public class MyRating {
	
	/**
	 * A film címe.
	 */
	private String title;
	/**
	 * A saját értékelésünk.
	 */
	private String rating;
	
	/**
	 * Visszaadja a film címét.
	 * 
	 * @return a film címe
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Módosítja a film címét.
	 * 
	 * @param title az a {@code String}, ami az új cím lesz
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Visszaadja a saját értékelésünket.
	 * 
	 * @return a saját értékelésünk
	 */
	public String getRating() {
		return rating;
	}
	
	/**
	 * Módosítja a saját értékelésünket.
	 * 
	 * @param rating az a {@code String}, ami az új értékelésünk lesz
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
