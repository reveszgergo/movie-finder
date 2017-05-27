package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.MyHighScore;

/**
 * A highscore-ok ({@link models.MyHighScore}) kezeléséhez használható függvények osztálya.
 */
public class HighScoreDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(HighScoreDAO.class);
	
	/**
	 * Visszaad egy high score-okat tartalmazó listát. Bármilyen hiba esetén egy új listát ad vissza.
	 * 
	 * @param location egy {@code String}, a high score-okat tartalmazó fájl helye
	 * @return a high score-okat tartalmazó lista vagy új lista
	 */
	public ArrayList <MyHighScore> getHighScores(String location){
		File f = new File(location);
		if(!f.exists()){
			return new ArrayList<MyHighScore>();
		}
		try {
			FileReader fr = new FileReader(f);
			Gson gson = new Gson();
			ArrayList<MyHighScore> myRating = gson.fromJson(fr, new TypeToken<List<MyHighScore>>(){}.getType());
			fr.close();
			return myRating;
		} catch (FileNotFoundException e) {
			logger.error("Kivétel: ", e);
			return new ArrayList<MyHighScore>();
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			return new ArrayList<MyHighScore>();
		}
	}
	
	/**
	 * Hozzáad egy high score-t a high score-okat tartalmazó listához.
	 * 
	 * @param highScore egy {@link models.MyHighScore}, a hozzáadni kívánt high score
	 */
	public void addHighScore(MyHighScore highScore){
		ArrayList<MyHighScore> scores = getHighScores(System.getProperty("user.home") + File.separator + "highscores.json");
		scores.add(highScore);
		File f = new File(System.getProperty("user.home") + File.separator + "highscores.json");
		try {
			FileWriter fw = new FileWriter(f);
			Gson gson = new Gson();
			gson.toJson(scores, fw);
			fw.close();
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Visszaadja a legjobb tíz helyezett listáját.
	 * 
	 * @return a legjobb tíz listája vagy új lista
	 */
	public ArrayList<MyHighScore> getTopTen(){
		ArrayList<MyHighScore> topTen = new ArrayList<MyHighScore>();
		ArrayList<MyHighScore> highScores = getHighScores(System.getProperty("user.home") + File.separator + "highscores.json");
		if(highScores.isEmpty()){
			return new ArrayList<MyHighScore>();
		}
		highScores.sort((h1, h2) -> Integer.compare(Integer.parseInt(h2.getPoint()), Integer.parseInt(h1.getPoint())));
		if(highScores.size() < 11){
			for(int i=0; i<highScores.size(); i++){
				topTen.add(highScores.get(i));
			}
			return topTen;
		}else{
			for(int i=0; i<10; i++){
				topTen.add(highScores.get(i));
			}
			return topTen;
		}
			
	}
}
