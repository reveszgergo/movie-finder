package controllers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.MovieDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Movie;

public class MovieController {
	
	private static Logger logger = LoggerFactory.getLogger(MovieController.class);
	private MovieDAO movie;
	private Movie searchedMovie;
	
	@FXML
	private TextField movieTitle;
	@FXML
	private Label title;
	@FXML
	private Label year;
	@FXML
	private Label rated;
	@FXML
	private Label runtime;
	@FXML
	private Label genre;
	@FXML
	private Label director;
	@FXML
	private Label actors;
	@FXML
	private Label metascore;
	@FXML
	private Label myscore;
	@FXML
	private ImageView poster;
	@FXML
	private TextField newMyScore;
	
	@FXML
	private void initialize(){
		
		movie = new MovieDAO();
		searchedMovie = new Movie();
	}
	
	@FXML
	private void search(){
		try {
			if(!movieTitle.getText().isEmpty()){
				try{
				InetSocketAddress socketAddress = new InetSocketAddress("www.google.com", 80); 
				SocketChannel channel = SocketChannel.open(); 
				channel.configureBlocking(false); 
				channel.connect(socketAddress);
				}catch(UnresolvedAddressException e){
					logger.error("Kivétel: ", e);
					return;
				}
				searchedMovie = movie.getMovie(movieTitle.getText());
				if(searchedMovie == null){
					logger.info("Nincs beírva film.");
				}else{
					updateScene();
					logger.info("Film adatai megjelenítve.");
				}
			}		
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
	}
	
	@FXML
	private void changeMyScore(){
		try{
			if(!newMyScore.getText().isEmpty() && Integer.parseInt(newMyScore.getText()) > 1 
					&& Integer.parseInt(newMyScore.getText()) < 10){
				searchedMovie.setMyscore(newMyScore.getText());
				updateScene();
				movie.updateMyRating(searchedMovie.getTitle(), newMyScore.getText());
			}
		}catch(NullPointerException e){
			logger.error("Kivétel: ", e);
		}	
	}
	
	public Label getTitle() {
		return title;
	}

	private void updateTitle(){
		if(!searchedMovie.getYear().equals(null)){
			title.setText(searchedMovie.getTitle());
		}else{
			title.setText("-");
		}
	}
	
	private void updateYear(){
		if(!searchedMovie.getYear().equals(null)){
			year.setText(searchedMovie.getYear().toString());
		}else{
			year.setText("-");
		}
	}
	
	private void updateRated(){
		if(!searchedMovie.getYear().equals(null)){
			rated.setText(searchedMovie.getRated());
		}else{
			rated.setText("-");
		}
	}
	
	private void updateRuntime(){
		if(!searchedMovie.getYear().equals(null)){
			runtime.setText(searchedMovie.getRuntime());
		}else{
			runtime.setText("-");
		}
	}
	
	private void updateGenre(){
		if(!searchedMovie.getYear().equals(null)){
			genre.setText(searchedMovie.getGenre());
		}else{
			genre.setText("-");
		}
	}
	
	private void updateDirector(){
		if(!searchedMovie.getYear().equals(null)){
			director.setText(searchedMovie.getDirector());
		}else{
			director.setText("-");
		}
	}
	
	private void updateActors(){
		if(!searchedMovie.getYear().equals(null)){
			actors.setText(searchedMovie.getActors());
		}else{
			actors.setText("-");
		}
	}
	
	private void updateMetascore(){
		if(!searchedMovie.getYear().equals(null)){
			metascore.setText(searchedMovie.getMetascore());
		}else{
			metascore.setText("-");
		}
	}
	
	private void updateMyscore(){
		if(!searchedMovie.getYear().equals(null)){
			myscore.setText(searchedMovie.getMyscore());
		}else{
			myscore.setText("-");
		}
	}
	
	private void updatePoster(){
		if(searchedMovie.getPoster().equals("N/A")){
			Image image = new Image(getClass().getResourceAsStream("/No_image.png"));
			poster.setImage(image);
		}else{
			Image image = new Image(searchedMovie.getPoster());
			poster.setImage(image);
		}
	}
	
	public void updateScene(){
		updateTitle();
		updateYear();
		updateRated();
		updateRuntime();
		updateGenre();
		updateDirector();
		updateActors();
		updateMetascore();
		updateMyscore();
		updatePoster();
	}
	
}
