package com.my_project.mini_ERP.repository;

import com.my_project.mini_ERP.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
