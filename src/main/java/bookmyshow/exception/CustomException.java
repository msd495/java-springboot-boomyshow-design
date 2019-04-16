package bookmyshow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomException extends RuntimeException{

    public CustomException(String msg){
            super(msg);
    }

    public CustomException(String msg,String TheaterName){
        super(msg);
    }
}
