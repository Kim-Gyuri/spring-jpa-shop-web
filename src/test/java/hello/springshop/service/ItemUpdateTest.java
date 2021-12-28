package hello.springshop.service;

import hello.springshop.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired EntityManager em;

    @Test
    public void updateTest() throws Exception {

        Book book = em.find(Book.class, 1L);

        //tx
        book.setName("jpa");

        //tx.commit , 변경감지==dirty checking


        //when

        //then
    }
}
