package com.my_project.mini_ERP.model.sale;

import com.my_project.mini_ERP.model.product.Product;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate saleDate;
    @Column(precision = 19, scale = 2)
    private BigDecimal totalValue;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> items;

    public Sale(LocalDate saleDate, BigDecimal totalValue, List<SaleItem> items) {
        this.saleDate = saleDate;
        this.totalValue = totalValue;
        this.items = items;
    }
}
