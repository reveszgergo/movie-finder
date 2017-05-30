package models;

/**
 * Egy filmet reprezentáló osztály.
 */
public class Movie {
	
	/**
	 * A film címe.
	 */
	private String title;
	/**
	 * A film bemutatásának éve.
	 */
	private Integer year;
	/**
	 * A film korhatár besorolása.
	 */
	private String rated;
	/**
	 * A film hossza.
	 */
	private String runtime;
	/**
	 * A film műfaja.
	 */
	private String genre;
	/**
	 * A film rendezője.
	 */
	private String director;
	/**
	 * A film szereplői.
	 */
	private String actors;
	/**
	 * A film poszterének címe.
	 */
	private String poster;
	/**
	 * A film Metascoreja.
	 */
	private String metascore;
	/**
	 * Saját pontszám a filmről.
	 */
	private String myscore;

	/**
	 * Visszaadja a film címét.
	 * 
	 * @return a film címe
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Visszaadja a film bemutatásának évét.
	 * 
	 * @return a film bemutatásának éve
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Visszaadja a film korhatár besorolását.
	 * 
	 * @return a film címe
	 */
	public String getRated() {
		return rated;
	}

	/**
	 * Visszaadja a film hosszát.
	 * 
	 * @return a film hossza
	 */
	public String getRuntime() {
		return runtime;
	}

	/**
	 * Visszaadja a film műfaját.
	 * 
	 * @return a film műfaja
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Visszaadja a film rendezőjét.
	 * 
	 * @return a film rendezője
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Visszaadja a film szereplőit.
	 * 
	 * @return a film szereplői
	 */
	public String getActors() {
		return actors;
	}

	/**
	 * Visszaadja a film poszterének címét.
	 * 
	 * @return a film poszterének címe
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * Visszaadja a film Metascoreját.
	 * 
	 * @return a film Metascoreja
	 */
	public String getMetascore() {
		return metascore;
	}

	/**
	 * Visszaadja a saját pontszámunkat a filmről.
	 * 
	 * @return saját pontszám a filmről
	 */
	public String getMyscore() {
		return myscore;
	}

	/**
	 * Módosítja a saját pontszámunkat.
	 * 
	 * @param myscore az a {@code String}, ami az új pontszámunk lesz
	 */
	public void setMyscore(String myscore) {
		this.myscore = myscore;
	}
	
}
