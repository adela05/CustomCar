package com.company.CustomCar.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inventoryId;
    @NotEmpty
    @Length(max = 15)
    private String status;
    private Integer itemId;

    // Joining Inventory to Orders Class.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", updatable = false, insertable = false)



    // Getter and Setter
    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItems(Integer items) {
        this.itemId = itemId;
    }
}
