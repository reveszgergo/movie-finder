package controllers;

import java.util.ArrayList;

import dao.HighScoreDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.MyHighScore;

public class HighScoreTableController {
	MyHighScore myHighScore;
	HighScoreDAO highScoreDAO;
	
	@FXML
	private Label name1;
	@FXML
	private Label name2;
	@FXML
	private Label name3;
	@FXML
	private Label name4;
	@FXML
	private Label name5;
	@FXML
	private Label name6;
	@FXML
	private Label name7;
	@FXML
	private Label name8;
	@FXML
	private Label name9;
	@FXML
	private Label name10;
	@FXML
	private Label point1;
	@FXML
	private Label point2;
	@FXML
	private Label point3;
	@FXML
	private Label point4;
	@FXML
	private Label point5;
	@FXML
	private Label point6;
	@FXML
	private Label point7;
	@FXML
	private Label point8;
	@FXML
	private Label point9;
	@FXML
	private Label point10;
	
	@FXML
	private void initialize(){
		myHighScore = new MyHighScore();
		highScoreDAO = new HighScoreDAO();
		update();
	}
	
	public void update(){
		ArrayList<Label> names = new ArrayList<Label>();
		ArrayList<Label> points = new ArrayList<Label>();
		names.add(name1);
		names.add(name2);
		names.add(name3);
		names.add(name4);
		names.add(name5);
		names.add(name6);
		names.add(name7);
		names.add(name8);
		names.add(name9);
		names.add(name10);
		points.add(point1);
		points.add(point2);
		points.add(point3);
		points.add(point4);
		points.add(point5);
		points.add(point6);
		points.add(point7);
		points.add(point8);
		points.add(point9);
		points.add(point10);
		for(int i=0; i<highScoreDAO.getTopTen().size(); i++){
			names.get(i).setText(highScoreDAO.getTopTen().get(i).getName());
			points.get(i).setText(highScoreDAO.getTopTen().get(i).getPoint());
		}
	}
}
