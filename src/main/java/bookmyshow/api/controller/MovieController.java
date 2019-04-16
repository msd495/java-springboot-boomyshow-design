package bookmyshow.controller;


import bookmyshow.api.services.HazzleCastService;
import bookmyshow.api.services.MailService;
import bookmyshow.api.services.RabbitmqProducer;
import bookmyshow.dao.MovieDao;
import bookmyshow.exception.CustomException;
import bookmyshow.model.Mail;
import bookmyshow.model.Movie;
import bookmyshow.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MailService mailService;

    @Autowired
    RabbitmqProducer rabbitmqProducer;

    @Autowired
    HazzleCastService hazlecastService;

    @PostMapping(value="/insertMovie")
    public ResponseEntity<Object> insertMovies(@RequestBody Movie movie){

        return new ResponseEntity(movieDao.save(movie), HttpStatus.OK);
    }

    @RequestMapping(value="/getAllMovie")
    public List<Movie> getAllMovies(){

        //return movieDao.getAllMovies();
        List<Movie> movieList=new ArrayList<>();
        movieList.add(new Movie("5c9274836b4dbb26447861f3","hindi","ddlj","9.5","srk","kajol","awesome movie","love story",new Theater(123,"pvr","thanisandra")));
        return movieList;
    }

    @RequestMapping(value="/searchMovie/{movieName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMovie(@PathVariable("movieName") String movieName){

                Optional<Movie> movieBoolean= Optional.ofNullable(movieDao.getMovie(movieName));
                if(movieBoolean.isPresent()){
                    return new ResponseEntity(movieDao.getMovie(movieName), HttpStatus.OK);
                }
                else{
                    throw new CustomException("not founds");
                    //return ResponseEntity.badRequest().body("Movie not found");
                }

    }

    @RequestMapping(value="/searchMovieByTheater/{movieName}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMovieByTheater(@PathVariable("movieName") String TheaterName)throws CustomException{

        try {
            List<Movie> movieByTheater = movieDao.getMovieByTheater(TheaterName);
            if (!movieByTheater.isEmpty()) {
                final ResponseEntity responseEntity = new ResponseEntity(movieDao.getMovieByTheater(TheaterName), HttpStatus.OK);
                return responseEntity;
            } else {
                throw new CustomException("No movie found for ", TheaterName);
                //return ResponseEntity.badRequest().body("Movie not found");
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    public String sendMail(@RequestBody Mail mail){
        return mailService.sendMail(mail);
    }

    @RequestMapping("/sendToQueue")
    public String sendMsg(@RequestParam("msg") String msg){

        rabbitmqProducer.produceMsg(msg);
        return "Sent msg to RabbitMq";
        /*https://grokonez.com/java-integration/distributed-system/create-spring-rabbitmq-producerconsumer-application-springboot*/
    }

    @RequestMapping("/storeInHazleCast")
    public String writeDataToHazelcast(@RequestParam String key, @RequestParam String value) {
        return hazlecastService.writeDataToHazelcast(key,value);
    };

    @RequestMapping("/getFromHazleCast")
    public String readDataFromHazelcast(@RequestParam String key) {
        return hazlecastService.readDataFromHazelcast(key);
    };

    @RequestMapping("/getAllDataFromHazleCast")
    public Map<String, String> readAllDataFromHazelcast() {
        return hazlecastService.readAllDataFromHazelcast();
    };

}
