package api.models.book;

import lombok.Data;

@Data
public class BookRecords {
    String id;
    int bookId;
    String customerName;
    int quantity;
}
