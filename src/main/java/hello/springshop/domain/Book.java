package hello.springshop.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
public class Book extends Item {

    private String author;
    private String isbn;

    private Book(String name, int price, int stockQuantity, String author, String isbn ) {
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
    public void updateBook(String name, int price, int stockQuantity, String author, String isbn){
        addItem(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }


}
