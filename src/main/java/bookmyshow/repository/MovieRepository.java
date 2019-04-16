package bookmyshow.repository;

import bookmyshow.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface MovieRepository extends MongoRepository<Movie,Integer> {

    @Query(value = "{ 'movieName' : ?0}")
    Movie findByName(String movieName);
    @Query(value = "{ 'theater.theaterName' : ?0}")
    List<Movie> findByTheaterName(String theaterName);
}
