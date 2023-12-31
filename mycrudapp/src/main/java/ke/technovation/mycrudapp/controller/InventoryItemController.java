package ke.technovation.mycrudapp.controller;

import ke.technovation.mycrudapp.Service.InventoryItemService;
import ke.technovation.mycrudapp.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*", maxAge = 3600)

public class InventoryItemController {
    private InventoryItemService inventoryItemService;

    // comment
    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    //   Delegate the request to the service class and return the response
    @GetMapping()
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public InventoryItem getItemById(@PathVariable Long id) {
        return inventoryItemService.getItemById(id);
    }

    @PostMapping()
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryItemService.addItem(item);
    }

    public void InventoryItem(InventoryItemService inventoryItemService) {
    }

    @PutMapping
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem item) {
        return inventoryItemService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryItemService.deleteItem(id);
    }
}



