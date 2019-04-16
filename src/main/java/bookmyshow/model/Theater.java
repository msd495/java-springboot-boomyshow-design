package bookmyshow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Theater {

    private Integer theaterId;
    private String theaterName;
    private String address;

    public Theater(){};

    public Theater(
            final Integer theaterId,
            final String theaterName,
            final String address) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.address = address;
    }
}

//https://lankydanblog.com/2017/05/29/embedded-documents-with-spring-data-and-mongodb/
