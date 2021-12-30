package hello.springshop.domain;

import hello.springshop.repository.dto.UpdateItemDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
public class Book extends Item {

    private String author;
    private String isbn;
/*
    private Book(String name, int price, int stockQuantity, String author, String isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
*/
    /*
    builder
     */
    @Builder
    public Book(String name, int price, int stockQuantity, String author, String isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

    /*
    정적 팩토리 메소드 생성
     */
    public static Book createItem(String name, int price, int stockQuantity, String author, String isbn) {
        Book book = new Book(name, price, stockQuantity, author, isbn);
        return book;
    }

    /*
    update 변경 로직
     */
    public void updateBook(UpdateItemDto updateItemDto){
        this.author = updateItemDto.getAuthor();
        this.isbn = updateItemDto.getIsbn();
        this.setId(updateItemDto.getId());
        this.setName(updateItemDto.getName());
        this.setPrice(updateItemDto.getPrice());
        this.setStockQuantity(updateItemDto.getStockQuantity());
    }


}
