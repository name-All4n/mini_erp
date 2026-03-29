package com.my_project.mini_ERP.controller;

import com.my_project.mini_ERP.model.DataProductDetails;
import com.my_project.mini_ERP.model.DataProductListining;
import com.my_project.mini_ERP.model.DataProductRegister;
import com.my_project.mini_ERP.model.Product;
import com.my_project.mini_ERP.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerProduct(@Valid @RequestBody DataProductRegister data) {
        var prodcuct = new Product(data);
        productRepository.save(prodcuct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DataProductListining>> list(@PageableDefault(size=10, sort={"name"}) Pageable pagination) {
        var page = productRepository.findAllByActiveTrue(pagination).map(DataProductListining::new);
        return ResponseEntity.ok(page);
    }
}
