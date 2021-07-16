package com.pwr.AngularSpring.Store.controllers;

import com.pwr.AngularSpring.Store.exceptions.ProductNotFoundException;
import com.pwr.AngularSpring.Store.model.Product;
import com.pwr.AngularSpring.Store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_manager")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getById(@PathVariable(required = true) Long id) throws ProductNotFoundException {
      return ResponseEntity.ok(productService.getProduct(id));
    }
    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
         List<Product> products = productService.getAllProducts();
         return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable(required = true) Long id) throws ProductNotFoundException {

          productService.deleteProduct(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateProduct = productService.addProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }


}

