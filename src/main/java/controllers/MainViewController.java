package controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;

public class MainViewController {
	private static Logger logger = LoggerFactory.getLogger(MainViewController.class);
	private static final String SEARCHMOVIE = "/fxml/Movie.fxml";
	private static final String QUIZ = "/fxml/MultipleChoiceQuestion.fxml";
	private static final String HIGHSCORETABLE = "/fxml/HighScoreTable.fxml";
	
	@FXML
	private void searchMovie(){
		loadMenuPoint(SEARCHMOVIE, "Filmkereső");
	}
	
	@FXML
	private void quiz(){
		loadMenuPoint(QUIZ, "Kvíz");
	}
	
	@FXML
	private void highScoreTable(){
		loadMenuPoint(HIGHSCORETABLE, "Eredmények");
	}
	
	@FXML
	private void exit(){
		Main.closeStage();
	}
	
	private void loadMenuPoint(String fxml, String title){
		
		try {
			Stage stage = new Stage();
			
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setTitle(title);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
	}
}
