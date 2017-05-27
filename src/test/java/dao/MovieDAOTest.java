package dao;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MovieDAOTest {

	private MovieDAO movieDAO;
	
	@Before
	public void setUp(){
		movieDAO = new MovieDAO();
	}
	
	@Test
	public void getMovieTest() throws IOException{
		assertEquals(null, movieDAO.getMovie("valami film"));
		assertEquals("Star Wars: Episode IV - A New Hope", movieDAO.getMovie("Star Wars").getTitle());
	}

}
