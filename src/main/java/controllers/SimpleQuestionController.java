package controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.HighScoreDAO;
import dao.Quiz;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import models.MyHighScore;
import models.SimpleQuestion;
import point.HighScoreCalculator;

public class SimpleQuestionController {

	private static Logger logger = LoggerFactory.getLogger(SimpleQuestionController.class);
	
	private SimpleQuestion simplequestion;
	private Quiz quizDAO;
	private HighScoreCalculator highScoreCalculator;
	private HighScoreDAO highScoreDAO;
	private int counter = 0;
	
	@FXML
	private Label question;
	@FXML
	private TextField answer;
	@FXML
	private Button checkAnswer;
	
	@FXML
	private void initialize(){
		simplequestion = new SimpleQuestion();
		highScoreDAO = new HighScoreDAO();
		quizDAO = new Quiz();
		simplequestion = quizDAO.getSimpleQuestion();
		question.setText(simplequestion.getQuestion());
	}

	public void setHighScoreCalculator(HighScoreCalculator highScoreCalculator) {
		this.highScoreCalculator = highScoreCalculator;
	}

	@FXML
	private void checkAnswer(){
		if(!answer.getText().isEmpty()){
			if(answer.getText().toLowerCase().replaceAll(" ", "").equals(simplequestion.getAnswer().toLowerCase().replaceAll(" ", ""))){
				updateQuestion();
				counter+=1;
				highScoreCalculator.addPoint(simplequestion.getPoint());
				if(counter == 5){
					dialogWindow();
					Stage stage = (Stage) checkAnswer.getScene().getWindow();
				    stage.close();
				}
			}else{
				dialogWindow();
				Stage stage = (Stage) checkAnswer.getScene().getWindow();
			    stage.close();
			}
		}
	}
	
	public void updateQuestion(){
		simplequestion = quizDAO.getSimpleQuestion();
		question.setText(simplequestion.getQuestion());
		answer.setText(" ");
	}
	
	private void dialogWindow(){
		TextInputDialog dialog = new TextInputDialog("Anonymous");
		dialog.setTitle("Név megadása");
		dialog.setHeaderText("A pontszámod: " + highScoreCalculator.getPoint());
		dialog.setContentText("Add meg a neved! ");

		logger.info("Dialógusablak megjelenítve.");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    MyHighScore myHighScore = new MyHighScore();
			myHighScore.setName(result.get());
			myHighScore.setPoint(Integer.toString(highScoreCalculator.getPoint()));
			
			highScoreDAO.addHighScore(myHighScore);
		}
	}
}
