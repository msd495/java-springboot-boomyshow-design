package bookmyshow.dao;

import bookmyshow.exception.CustomException;
import bookmyshow.model.Movie;

import java.util.List;

public interface MovieDao {

    public Movie save(Movie movie);

    public List<Movie> getAllMovies();

    public Movie getMovie(String movieName) throws CustomException;

    public List<Movie> getMovieByTheater(String TheaterName) throws CustomException;

}
