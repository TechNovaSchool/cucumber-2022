package api.models;

import lombok.Data;

@Data
public class Record {
    String id;
    String createdTime;
    MyFields fields;
}
