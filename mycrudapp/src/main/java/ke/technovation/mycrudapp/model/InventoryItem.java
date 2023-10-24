package ke.technovation.mycrudapp.model;

import org.apache.el.util.Validation;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;

public class InventoryItem {
    private Long id;
    private String name;
    private String description;
    private int quantity;

    // Constructors, getters, and setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}





