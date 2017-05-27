package dao;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Movie;
import models.MyRating;

/**
 * A filmek ({@link models.Movie}) kezeléséhez használt függvények osztálya.
 */
public class MovieDAO {
	
	/**
	 * Az OMDB api címe.
	 */
	public static final String OMDB_API_ADDRESS = "http://www.omdbapi.com/?apikey=229651fc&t=";
	
	/**
	 * Visszaadja a lekérdezett filmet. Ha nem találja a lekérdezett filmet, {@code null} értékkel tér vissza.
	 * @param searchedMovie egy {@code String}, a keresett film címe
	 * @return a keresett film vagy {@code null}
	 * @throws IOException ha bármilyen I/O hiba lép fel
	 */
	public Movie getMovie(String searchedMovie) throws IOException{
		searchedMovie = searchedMovie.toLowerCase().replaceAll(" ", "+");
		URL url = new URL(OMDB_API_ADDRESS + searchedMovie);
		HttpURLConnection	conn = (HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new IOException(conn.getResponseMessage());
		}
		String	s = IOUtils.toString(conn.getInputStream(), "UTF-8");
		if(s.contains("\"Response\":\"False\"")){
			return null;
		}
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		Movie movie = gson.fromJson(s, Movie.class);
		
		MyRatingDAO mrd = new MyRatingDAO();
		List<MyRating> ratings = mrd.getRatings(System.getProperty("user.home") + File.separator + "myratings.json");
		for(MyRating r : ratings){
			if (r.getTitle().equals(movie.getTitle())){
				movie.setMyscore(r.getRating());
				break;
			}else{
				movie.setMyscore(" ");
			}
		}
		return movie;
	}
	
	/**
	 * Frissíti és visszaadja a saját értékelésünket.
	 * 
	 * @param title egy {@code String}, a film címe
	 * @param rating egy {@code String}, az értékelés, amit be akarunk állítani
	 * @return a frissített értékelés
	 */
	public MyRating updateMyRating(String title, String rating){
		MyRatingDAO mrd = new MyRatingDAO();
		MyRating myRating = new MyRating();
		myRating.setTitle(title);
		myRating.setRating(rating);
		mrd.addRating(myRating);
		return myRating;
	}

}
