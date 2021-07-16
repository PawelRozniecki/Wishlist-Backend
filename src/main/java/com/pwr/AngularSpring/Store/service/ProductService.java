package com.pwr.AngularSpring.Store.service;

import com.pwr.AngularSpring.Store.exceptions.ProductNotFoundException;
import com.pwr.AngularSpring.Store.model.Product;
import com.pwr.AngularSpring.Store.repositories.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with id " + id + " not found"));
    }
    public void deleteProduct(Long id) throws ProductNotFoundException{
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
        }else{
            throw  new ProductNotFoundException("Product with id " + id + " not found");
        }
    }
}
