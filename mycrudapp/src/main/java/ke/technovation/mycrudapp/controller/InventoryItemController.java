package ke.technovation.mycrudapp.controller;

import ke.technovation.mycrudapp.Service.InventoryItemService;
import ke.technovation.mycrudapp.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= "*", maxAge = 3600)

@RestController
@RequestMapping("/api/inventory")
public abstract class InventoryItemController {

    private  InventoryItemService inventoryItemService;

    // comment
    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    //   Delegate the request to the service class and return the response
    @GetMapping("/")
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public InventoryItem getItemById(@PathVariable Long id) {
        return inventoryItemService.getItemById(id);
    }

    @PostMapping("/")
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryItemService.addItem(item);
    }
    public void InventoryItem(InventoryItemService inventoryItemService){
    }

    @PutMapping("/{id}")
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem item) {
        return inventoryItemService.updateItem(id, item);
    }


    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryItemService.deleteItem(id);
    }
}



