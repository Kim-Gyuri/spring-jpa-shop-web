package hello.springshop.repository.dto;

import hello.springshop.web.BookForm;
import lombok.Data;

@Data
public class UpdateItemDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    public UpdateItemDto(BookForm book){
        id = book.getId();
        name = book.getName();
        price = book.getPrice();
        stockQuantity = book.getStockQuantity();
        author = book.getAuthor();
        isbn = book.getIsbn();
    }

}
