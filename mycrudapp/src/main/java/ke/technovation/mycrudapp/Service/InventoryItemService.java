package ke.technovation.mycrudapp.Service;

import ke.technovation.mycrudapp.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryItemService {
    //edward comment to test commit
    private final List<InventoryItem> inventoryItems = new ArrayList<>();
    private long idCounter = 1;

    public List<InventoryItem> getAllItems() {
        return inventoryItems;
    }

    // Logic to find and return an item by ID
    public InventoryItem getItemById(Long id) {
        return inventoryItems.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
    //Logic to add a new item

    public InventoryItem addItem(InventoryItem item) {
        String itemName = item.getName();
        if (itemName == null) {
            return null;
        }
        int itemQuantity = item.getQuantity();
        if (itemQuantity <= 0) {
            return null;
        }
        int itemPrice = item.getPrice();
        if (itemPrice <= 0) {
            return null;
        }
        item.setId(idCounter++);
        inventoryItems.add(item);
        return item;
    }
    //Logic to update an existing item

    public InventoryItem updateItem(Long id, InventoryItem item) {
        for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getId().equals(id)) {
                item.setId(id);
                inventoryItems.set(i, item);
                return item;
            }
        }
        return null;
    }
    // Logic to delete an item

    public void deleteItem(Long id) {
        inventoryItems.removeIf(item -> item.getId().equals(id));
    }
}



