package hello.springshop.repository.dto;

import hello.springshop.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveItemDto {


    private String Name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    @Builder
    public SaveItemDto(String name, int price, int stockQuantity, String author, String isbn) {
        this.Name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.author = author;
        this.isbn = isbn;
    }

    public Book toEntity() {
        return Book.builder()
                .name(builder().name)
                .price(builder().price)
                .stockQuantity(builder().stockQuantity)
                .author(author)
                .isbn(isbn)
                .build();
    }





}
