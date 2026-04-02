package com.my_project.mini_ERP.repository;

import com.my_project.mini_ERP.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByActiveTrue(Pageable  pagination);
}
