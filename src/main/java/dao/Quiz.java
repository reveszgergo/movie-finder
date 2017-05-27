package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		File f = new File(classLoader.getResource("multiplechoicequestions.json").getFile());
		
		try {
			FileReader fr = new FileReader(f);
			Gson gson = new Gson();
			
			MultipleChoiceQuestion multiplechoicequestions[] = gson.fromJson(fr, MultipleChoiceQuestion[].class);
			fr.close();
			Random rand = new Random();
			int randomNum = rand.nextInt(50) + 0;
			while(randomNums.contains(randomNum)){
				randomNum = rand.nextInt(50) + 0;
			}
			randomNums.add(randomNum);
			return multiplechoicequestions[randomNum];
			
		} catch (FileNotFoundException e) {
			logger.error("Kivétel: ", e);
			return new MultipleChoiceQuestion();
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
		File f = new File(classLoader.getResource("simplequestions.json").getFile());
		
		try {
			FileReader fr = new FileReader(f);
			Gson gson = new Gson();
			
			SimpleQuestion simplequestions[] = gson.fromJson(fr, SimpleQuestion[].class);
			fr.close();
			Random rand = new Random();
			int randomNum = rand.nextInt(50) + 0;
			while(randomNums.contains(randomNum)){
				randomNum = rand.nextInt(50) + 0;
			}
			randomNums.add(randomNum);
			return simplequestions[randomNum];
			
		} catch (FileNotFoundException e) {
			logger.error("Kivétel: ", e);
			return new SimpleQuestion();
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			return new SimpleQuestion();
		}
	}
}
