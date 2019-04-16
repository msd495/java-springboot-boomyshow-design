package bookmyshow.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document
public class Movie {

    @Id
    private ObjectId _id;

    private String language;

    private String movieName;

    private String imdbRating;

    private String actor;

    private String actoress;

    private String reviews;

    private String genre;

    private Theater theater;

    public Movie(String id, String language, String movieName, String imdbRating, String actor, String actoress, String reviews, String genre, Theater theater){
        this.language=language;
        this.movieName=movieName;
        this.imdbRating=imdbRating;
        this.actor=actor;
        this.actoress=actoress;
        this.reviews=reviews;
        this.genre=genre;
        this.theater=theater;

    }

    public Movie(ObjectId _id,String language,String movieName,String imdbRating,
                 String actor,String actoress,String reviews,String genre,Theater theater){
                this._id=_id;
                this.language=language;
                this.movieName=movieName;
                this.imdbRating=imdbRating;
                this.actor=actor;
                this.actoress=actoress;
                this.reviews=reviews;
                this.genre=genre;
                this.theater=theater;

    }

}
