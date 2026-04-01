package com.my_project.mini_ERP.controller;

import com.my_project.mini_ERP.model.*;
import com.my_project.mini_ERP.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("Product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerProduct(@Valid @RequestBody DataProductRegister data, UriComponentsBuilder ucBuilder) {
        var product = new Product(data);
        productRepository.save(product);
        var uri = ucBuilder.path("/Product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataProductDetails(product));
    }

    @GetMapping
    public ResponseEntity<Page<DataProductListining>> list(@PageableDefault(size=10, sort={"name"}) Pageable pagination) {
        var page = productRepository.findAllByActiveTrue(pagination).map(DataProductListining::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataProductUpdate data) {
        var product = productRepository.getReferenceById(data.id());
        product.updateInformations(data);
        return ResponseEntity.ok(new DataProductDetails(product));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id){
        var product = productRepository.getReferenceById(id);
        product.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var product = productRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataProductDetails(product));
    }
}
