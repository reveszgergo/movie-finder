package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import models.MultipleChoiceQuestion;
import models.SimpleQuestion;

/**
 * A feleletválasztós ({@link models.MultipleChoiceQuestion}) és a válaszolós ({@link models.SimpleQuestion}) kezelésére
 * használható függvényeket tartalmazó osztály.
 */
public class Quiz {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(Quiz.class);
	
	/**
	 * Egy random számokat tartalmazó lista.
	 */
	private List<Integer> randomNums = new ArrayList<Integer>();
	
	/**
	 * Visszaad egy random feleletválasztós kérdést. Bármilyen hiba esetén egy új kérdést ad vissza.
	 * 
	 * @return a fájlból kiválasztott kérdés vagy új kérdés
	 */
	public MultipleChoiceQuestion getMultipleQuestion(){
		ClassLoader classLoader = getClass().getClassLoader();
		
		try {
			Gson gson = new Gson();
			
			InputStream in = classLoader.getResourceAsStream("multiplechoicequestions.json");
			
			String input = IOUtils.toString(in, "UTF-8");
			
			MultipleChoiceQuestion multiplechoicequestions[] = gson.fromJson(input, MultipleChoiceQuestion[].class);
			Random rand = new Random();
			int randomNum = rand.nextInt(50) + 0;
			while(randomNums.contains(randomNum)){
				randomNum = rand.nextInt(50) + 0;
			}
			randomNums.add(randomNum);
			return multiplechoicequestions[randomNum];
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			return new MultipleChoiceQuestion();
		}
	}
	
	/**
	 * Visszaad egy random válaszolós kérdést. Bármilyen hiba esetén egy új kérdést ad vissza.
	 * 
	 * @return a fájlból kiválasztott kérdés vagy új kérdés
	 */
	public SimpleQuestion getSimpleQuestion(){
		ClassLoader classLoader = getClass().getClassLoader();
		
		try {
			Gson gson = new Gson();
			
			InputStream in = classLoader.getResourceAsStream("simplequestions.json");
			
			String input = IOUtils.toString(in, "UTF-8");
			
			SimpleQuestion simplequestions[] = gson.fromJson(input, SimpleQuestion[].class);
			Random rand = new Random();
			int randomNum = rand.nextInt(50) + 0;
			while(randomNums.contains(randomNum)){
				randomNum = rand.nextInt(50) + 0;
			}
			randomNums.add(randomNum);
			return simplequestions[randomNum];
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			return new SimpleQuestion();
		}
	}
}
