package ke.technovation.mycrudapp.controller;

import ke.technovation.mycrudapp.Service.InventoryItemService;
import ke.technovation.mycrudapp.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*", maxAge = 3600)

public class InventoryItemController {
    private InventoryItemService  inventoryItemService;

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

   // @PostMapping()
    //public InventoryItem addItem(@RequestBody InventoryItem item) {
        //return inventoryItemService.addItem(item);
    //}

    //public void InventoryItem(InventoryItemService inventoryItemService) {
    //}
    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestParam String itemName, @RequestParam int quantity) {
        boolean added = InventoryItemService.addItem(itemName, quantity);
        if (added) {
            return new ResponseEntity<>("Item added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Item already exists. Quantity updated.", HttpStatus.OK);
        }
    }

    @PutMapping("/Update")
    public ResponseEntity<String> updateItem(@RequestParam String itemName,@RequestParam int quantity ){
        inventoryItemService.updateItem(itemName, quantity);
        return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
    }

    //@PutMapping()
   // public InventoryItem updateItem( @RequestBody InventoryItem item) {
   //     return inventoryItemService.updateItem(item);
   // }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryItemService.deleteItem(id);
    }
}



