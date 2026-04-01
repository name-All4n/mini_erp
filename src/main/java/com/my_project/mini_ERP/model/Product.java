package com.my_project.mini_ERP.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(precision = 19, scale = 2)
    private BigDecimal price;
    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;
    private boolean active;

    public Product(DataProductRegister data) {
        this.active = true;
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.quantityInStock = data.quantityInStock();
    }

    public void updateInformations(DataProductUpdate data) {
        if  (data.name() != null) {
            this.name = data.name();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.price() != null) {
            this.price = data.price();
        }
        if (data.quantityInStock() != null) {
            this.quantityInStock = data.quantityInStock();
        }
    }

    public void delete() {
        this.active = false;
    }
}
