package ke.technovation.mycrudapp.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ke.technovation.mycrudapp.model.InventoryItem;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class  InventoryItemService {
    //edward comment to test commit
    private static final List<InventoryItem> inventoryItems = new ArrayList<>();
    private static long idCounter = 1;

    public List<InventoryItem> getAllItems() {
        return inventoryItems;
    }

    // Logic to find and return an item by ID
    public InventoryItem getItemById(Long id) {
        return inventoryItems.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
    //Logic to add a new item

    public static InventoryItem addItem(InventoryItem item) {
        if (validateItem(item)) return null;
        for (int i = 0; i < inventoryItems.size(); i++) {
            InventoryItem currentItem = inventoryItems.get(i);
            System.out.println("currentItem = " + currentItem);
            boolean isPresent = currentItem.getName() == item.getName();
            System.out.println("isPresent = " + isPresent);
            if (isPresent) {
                int currentQuantity = currentItem.getQuantity();
                int newQuantity = currentQuantity + item.getQuantity();
                currentItem.setQuantity(newQuantity);
                inventoryItems.set(i, currentItem);
                return item;
            }
        }
        item.setId(idCounter++);
        inventoryItems.add(item);
        return item;
    }

    public static boolean addItem(String itemName, int quantity) {
        InventoryItem result = null;
        for (int i = 0; i < inventoryItems.size(); i++) {
            InventoryItem currentItem = inventoryItems.get(i);
            if (currentItem.getName().equals(itemName)) {
                int currentQuantity = currentItem.getQuantity();
                int newQuantity = currentQuantity + quantity;
                currentItem.setQuantity(newQuantity);
                inventoryItems.set(i, currentItem);
                result = currentItem;
                return true;
            }
        }
            InventoryItem newItem = new InventoryItem();
            newItem.setName(itemName);
            newItem.setQuantity(quantity);
             result = addItem(newItem);

        return result!=null;
    }

    //Logic to update an existing item

    public InventoryItem updateItem(InventoryItem item) {
        for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getId().equals(item.getId())) {
                inventoryItems.set(i, item);
                return item;
            }
        }
        return null;
    }
    public void updateItem(String itemName,int quantity) {
             //Check if item already exists
        for (InventoryItem item : inventoryItems) {
            if (item.getName().equals(itemName)){
            //Item already exists, update the quantity
               item.setQuantity(quantity);
                  return;
              }
              InventoryItem newItem = new InventoryItem();
              inventoryItems.add(newItem);
        }
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
        return null;}
}





















