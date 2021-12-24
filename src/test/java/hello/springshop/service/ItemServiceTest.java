package hello.springshop.service;

import hello.springshop.domain.Item;
import hello.springshop.exception.NotEnoughStockException;
import hello.springshop.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;
    @Autowired EntityManager em;

    @Test
    public void 재고감소() throws Exception {
        //given
        Item item = mock(Item.class,  CALLS_REAL_METHODS);
        item.setStockQuantity(10);

        //when
        item.removeStock(12);

        //then
        assertThrows(NotEnoughStockException.class, () -> {
            fail("재고가 부족하다.");
        });
    }

    @Test
    public void 재고찾기() throws Exception {
        //given
        Item itemA = mock(Item.class, withSettings().useConstructor().defaultAnswer(CALLS_REAL_METHODS));
        itemA.addStock(3);


        //then
        Assertions.assertEquals(3, itemA.getStockQuantity());

    }

}