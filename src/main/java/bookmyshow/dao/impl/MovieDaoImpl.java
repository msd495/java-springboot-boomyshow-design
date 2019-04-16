package bookmyshow.dao.impl;

import bookmyshow.dao.MovieDao;
import bookmyshow.exception.CustomException;
import bookmyshow.model.Movie;
import bookmyshow.exception.CustomException;
import bookmyshow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDaoImpl implements MovieDao {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie){
        return movieRepository.save(movie);

    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(String movieName) throws CustomException {
        try{
            return movieRepository.findByName(movieName);
        }
        catch(Exception e){
            throw new CustomException("not found");
        }

    }

    @Override
    public List<Movie> getMovieByTheater(String TheaterName) throws CustomException {
        try{
            return movieRepository.findByTheaterName(TheaterName);
        }
        catch(Exception e){
            throw new CustomException("No movie found in"+TheaterName);
        }

    }

}
