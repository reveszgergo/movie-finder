package models;

/**
 * Egy válaszolós kérdést reprezentáló osztály.
 */
public class SimpleQuestion {
	
	/**
	 * A kérdés.
	 */
	private String question;
	/**
	 * A helyes válasz a kérdésre
	 */
	private String answer;
	/**
	 * Mennyi pontot ér a kérdés.
	 */
	private int point = 2;
	
	/**
	 * Visszaadja a kérdést.
	 * 
	 * @return a kérdés
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Visszaadja a helyes választ.
	 * 
	 * @return a helyes válasz
	 */
	public String getAnswer() {
		return answer;
	}
	
	/**
	 * Visszaadja a kérdés pontszámát.
	 * 
	 * @return a kérdés pontszáma
	 */
	public int getPoint(){
		return point;
	}

}
