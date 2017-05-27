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

import models.MyRating;

/**
 * A saját értékelések ({@link models.MyRating}) kezeléséhez használható függvények osztálya.
 */
public class MyRatingDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(MyRatingDAO.class);
	
	/**
	 * Visszaadja az értékeléseket tartalmazó listát. Bármilyen hiba esetén egy új listát ad vissza.
	 * 
	 * @param location egy {@code String}, az értékeléseket tartalmazó fájl helye
	 * @return az értékeléseket tartalamazó lista vagy új lista
	 */
	public ArrayList <MyRating> getRatings(String location){
		File f = new File(location);
		if(!f.exists()){
			return new ArrayList<MyRating>();
		}
		try {
			FileReader fr = new FileReader(f);
			Gson gson = new Gson();
			ArrayList<MyRating> myRating = gson.fromJson(fr, new TypeToken<List<MyRating>>(){}.getType());
			fr.close();
			return myRating;
		} catch (FileNotFoundException e) {
			logger.error("Kivétel: ", e);
			return new ArrayList<MyRating>();
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			return new ArrayList<MyRating>();
		}
	}
	
	/**
	 * Hozzáad egy új értékelést az értékeléseket tartalmazó listához.
	 * 
	 * @param rating egy {@code MyRating}, az új értékelés
	 */
	public void addRating(MyRating rating){
		ArrayList<MyRating> ratings = getRatings(System.getProperty("user.home") + File.separator + "myratings.json");
		boolean isInTheList = false;
		for(MyRating r : ratings){
			if(r.getTitle().equals(rating.getTitle())){
				r.setRating(rating.getRating());
				isInTheList = true;
				break;
			}
		}
		if(!isInTheList){
			ratings.add(rating);
		}
		File f = new File(System.getProperty("user.home") + File.separator + "myratings.json");
		try {
			FileWriter fw = new FileWriter(f);
			Gson gson = new Gson();
			gson.toJson(ratings, fw);
			fw.close();
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
	}
}
