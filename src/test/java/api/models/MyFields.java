package api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

@Data
public class MyFields {
    String address;
    String name;
    String phone;
    String notes;
    String email;
    boolean checkBox;
}
