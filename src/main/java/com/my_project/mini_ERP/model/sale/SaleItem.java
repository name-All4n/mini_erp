package com.my_project.mini_ERP.model.sale;

import com.my_project.mini_ERP.model.product.Product;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "sale_items")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="sale_id")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private Integer quantity;
    @Column(name="price_at_sale", precision = 19, scale = 2)
    private BigDecimal priceAtSale;

    public SaleItem(Sale sale, Product product, Integer quantity) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.priceAtSale = product.getPrice();
    }
}
