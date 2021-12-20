package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach//한 동작 끝날때마다 실행됨
    void afterEach() {
        itemRepository.clearStore();// 아까 만든 초기화 메서드
    }

    @Test//테스트떈 앞에 public 안써도됨.
    void save() {
        //given
        Item item = new Item("itemaA",10000,10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }


    @Test//테스트떈 앞에 public 안써도됨.
    void findall() {
        //given
    Item item1 = new Item("item1",10000,10);
    Item item2 = new Item("item2",20000,30);

    itemRepository.save(item1);
    itemRepository.save(item2);
        //when
    List<Item> result = itemRepository.findAll();
        //then
    assertThat(result.size()).isEqualTo(2);
    assertThat(result).contains(item1,item2);

    }

 @Test//테스트떈 앞에 public 안써도됨.
    void updateItem() {
        //given
        Item item = new Item("item1",10000,10);

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();
        //when
        Item updateParam = new Item("item2",20000,30);
        itemRepository.update(itemId,updateParam);

        //then
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}