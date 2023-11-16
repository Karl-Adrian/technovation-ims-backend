package ke.technovation.mycrudapp.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ke.technovation.mycrudapp.model.InventoryItem;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class  InventoryItemService {
    //edward comment to test commit
    private final List<InventoryItem> inventoryItems = new ArrayList<>();
    private long idCounter = 1;

    public List<InventoryItem> getAllItems() {
        return inventoryItems;
    }

    // Logic to find and return an item by ID
    public InventoryItem getItemById(Long id) {
        return  inventoryItems.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
    //Logic to add a new item

    public InventoryItem addItem(InventoryItem item) {
        if (validateItem(item)) return null;
        item.setId(idCounter++);
        inventoryItems.add(item);
        return item;
    }
    //Logic to update an existing item

    public InventoryItem updateItem( InventoryItem item) {
        if (validateItem(item)) return null;
        for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getId().equals(item.getId())) {
                Item foundItem = inventoryItems.get(i);
                foundItem.setPrice(item.getPrice());
                foundItem.setQuantity(item.getQuantity());
                foundItem.setName(item.getName())
                inventoryItems.set(i, foundItem);
                return foundItem;
            }
        }
        return null;
    }

    private static boolean validateItem(InventoryItem item) {
        return item.getName() == null || item.getQuantity() <= 0 || item.getPrice() <= 0;
    }
    // Logic to delete an item

    public void deleteItem(Long id) {
        inventoryItems.removeIf(item -> item.getId().equals(id));
    }

    public InventoryItem deleteItem(InventoryItem item) {
        if (item.getId() == null) {
            return null;
        }
        inventoryItems.removeIf(searchItem -> searchItem.getId().equals(item.getId()));
        return item;
    }

    public InventoryItem removeItem(InventoryItem item) {
        validateItem(item);
        return null;
    }
}





















