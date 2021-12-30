package hello.springshop.service;

import hello.springshop.domain.Book;
import hello.springshop.domain.Item;
import hello.springshop.repository.dto.SaveItemDto;
import hello.springshop.repository.dto.UpdateItemDto;
import hello.springshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;
/*
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
*/
    @Transactional
    public Long save(SaveItemDto saveItemDto) {
        return itemRepository.saveDto(saveItemDto.toEntity().getId());
    }

    @Transactional
    public void updateItem(UpdateItemDto updateItemDto) {
        Book foundedItem = (Book) itemRepository.findOne(updateItemDto.getId());
        foundedItem.updateBook(updateItemDto);
        log.info("update 실행");
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public void deleteItem(Long itemId) {
        itemRepository.delete(itemId);
    }
}
