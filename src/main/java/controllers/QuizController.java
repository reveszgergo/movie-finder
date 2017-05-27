package controllers;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.HighScoreDAO;
import dao.Quiz;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.MultipleChoiceQuestion;
import models.MyHighScore;
import point.HighScoreCalculator;

public class QuizController {
	private static Logger logger = LoggerFactory.getLogger(QuizController.class);
	
	private static final String SIMPLEQUESTION = "/fxml/SimpleQuestion.fxml";

	private MultipleChoiceQuestion multiplechoicequestion;
	private Quiz quizDAO;
	private HighScoreCalculator highScoreCalculator;
	private HighScoreDAO highScoreDAO;
	private int counter = 0;
	
	@FXML
	private Label question;
	@FXML
	private Button answer1;
	@FXML
	private Button answer2;
	@FXML
	private Button answer3;
	@FXML
	private Button answer4;
	
	@FXML
	private void initialize(){
		highScoreCalculator = new HighScoreCalculator();
		multiplechoicequestion = new MultipleChoiceQuestion();
		highScoreDAO = new HighScoreDAO();
		quizDAO = new Quiz();
		multiplechoicequestion = quizDAO.getMultipleQuestion();
		question.setText(multiplechoicequestion.getQuestion());
		answer1.setText(multiplechoicequestion.getC1());
		answer2.setText(multiplechoicequestion.getC2());
		answer3.setText(multiplechoicequestion.getC3());
		answer4.setText(multiplechoicequestion.getC4());
		
		logger.info("Kvízoldal megnyitva.");
	}
	
	@FXML
	private void answer1(){
		if(answer1.getText().equals(multiplechoicequestion.getCorrectanswer())){
			updateQuestion();
			counter += 1;
			highScoreCalculator.addPoint(multiplechoicequestion.getPoint());
			if(counter == 5){
				loadSimpleQuestion(SIMPLEQUESTION, "Kvíz");
				Stage stage = (Stage) answer3.getScene().getWindow();
			    stage.close();
			}
		}else{
			dialogWindow();
			Stage stage = (Stage) answer1.getScene().getWindow();
		    stage.close();
		}
	}
	
	@FXML
	private void answer2(){
		if(answer2.getText().equals(multiplechoicequestion.getCorrectanswer())){
			updateQuestion();
			counter += 1;
			highScoreCalculator.addPoint(multiplechoicequestion.getPoint());
			if(counter == 5){
				loadSimpleQuestion(SIMPLEQUESTION, "Kvíz");
				Stage stage = (Stage) answer3.getScene().getWindow();
			    stage.close();
			}
		}else{
			dialogWindow();
			Stage stage = (Stage) answer2.getScene().getWindow();
		    stage.close();
		}
	}
	
	@FXML
	private void answer3(){
		if(answer3.getText().equals(multiplechoicequestion.getCorrectanswer())){
			updateQuestion();
			counter += 1;
			highScoreCalculator.addPoint(multiplechoicequestion.getPoint());
			if(counter == 5){
				loadSimpleQuestion(SIMPLEQUESTION, "Kvíz");
				Stage stage = (Stage) answer3.getScene().getWindow();
			    stage.close();
			}
		}else{
			dialogWindow();
			Stage stage = (Stage) answer3.getScene().getWindow();
		    stage.close();
		}
	}
	
	@FXML
	private void answer4(){
		if(answer4.getText().equals(multiplechoicequestion.getCorrectanswer())){
			updateQuestion();
			counter += 1;
			highScoreCalculator.addPoint(multiplechoicequestion.getPoint());
			if(counter == 5){
				loadSimpleQuestion(SIMPLEQUESTION, "Kvíz");
				Stage stage = (Stage) answer3.getScene().getWindow();
			    stage.close();
			}
		}else{
			dialogWindow();
			Stage stage = (Stage) answer3.getScene().getWindow();
		    stage.close();
		}
	}
	
	public void updateQuestion(){
		multiplechoicequestion = quizDAO.getMultipleQuestion();
		question.setText(multiplechoicequestion.getQuestion());
		answer1.setText(multiplechoicequestion.getC1());
		answer2.setText(multiplechoicequestion.getC2());
		answer3.setText(multiplechoicequestion.getC3());
		answer4.setText(multiplechoicequestion.getC4());
	}
	
	private void loadSimpleQuestion(String fxml, String title){
		
		try {
			Stage stage = new Stage();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			Parent root = (Parent) loader.load();
			
			SimpleQuestionController controller = loader.getController();
			controller.setHighScoreCalculator(highScoreCalculator);
			
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
