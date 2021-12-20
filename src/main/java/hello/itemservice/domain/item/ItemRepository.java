package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();// 실제는 해쉬맵 사용x
    private static long sequence = 0L; //static 여러개가 동시에 접근시 hashmap사용 x

    public  Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);

    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());

    }

    public void clearStore() {
        store.clear(); //hashMap 데이터 초기화?

    }
}
