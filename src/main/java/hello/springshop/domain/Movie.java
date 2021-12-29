package hello.springshop.domain;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
public class Movie extends Item{

    private String director;
    private String actor;

    private Movie(String name, int price, int stockQuantity, String director, String actor) {
        super(name, price, stockQuantity);
        this.actor = actor;
        this.director = director;
    }
}
