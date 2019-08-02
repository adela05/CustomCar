package com.company.CustomCar.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    @NotEmpty
    @Length(max = 15)
    private String partType;

    // Joining the Supplier class to set the name for each item.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    // Getter and Setter
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
