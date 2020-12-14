package com.sklepmuzyczny.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ItemForm {
    @Min(value = 1)
    private Integer quantity;
    @NotEmpty
    private String productId;

    public ItemForm(@Min(value = 1) Integer quantity, @NotEmpty String productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

