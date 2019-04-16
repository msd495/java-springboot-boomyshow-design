package bookmyshow.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter

public class Address {

    private Integer addressId;

    private Integer theaterId;

    private String city;

    private String state;

    private String pinCode;

    private String streetAddress;

    private String landMark;




}
