package models;

/**
 * Egy feleletválasztós kérdést reprezentáló osztály.
 */
public class MultipleChoiceQuestion {
	
	/**
	 * A kérdés.
	 */
	private String question;
	/**
	 * Első válaszlehetőség.
	 */
	private String c1;
	/**
	 * Második válaszlehetőség.
	 */
	private String c2;
	/**
	 * Harmadik válaszlehetőség.
	 */
	private String c3;
	/**
	 * Negyedik válaszlehetőség.
	 */
	private String c4;
	/**
	 * A helyes válasz.
	 */
	private String correctAnswer;
	/**
	 * Mennyi pontot ér a kérdés.
	 */
	private int point = 1;
	
	/**
	 * Visszaadja a kérdést.
	 * 
	 * @return a kérdés
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Visszaadja az első válaszlehetőséget.
	 * 
	 * @return az első válaszlehetőség
	 */
	public String getC1() {
		return c1;
	}
	
	/**
	 * Visszaadja a második válaszlehetőséget.
	 * 
	 * @return a második válaszlehetőség
	 */
	public String getC2() {
		return c2;
	}
	
	/**
	 * Visszaadja a harmadik válaszlehetőséget.
	 * 
	 * @return a harmadik válaszlehetőség
	 */
	public String getC3() {
		return c3;
	}
	
	/**
	 * Visszaadja a negyedik válaszlehetőséget.
	 * 
	 * @return a negyedik válaszlehetőség
	 */
	public String getC4() {
		return c4;
	}
	
	/**
	 * Visszaadja a helyes választ.
	 * 
	 * @return a helyes válasz
	 */
	public String getCorrectanswer() {
		return correctAnswer;
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
