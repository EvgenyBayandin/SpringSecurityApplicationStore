package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.Product;
import com.example.springsecurityapplication.repositories.ProductRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //получаем список товаров
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //получаем товар по его id
    public Product getProductID(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // сохраняем товар
    @Transactional
    public void saveProduct(Product product){
        productRepository.save(product);
    }

    // обновляем товар
    @Transactional
    public void updateProduct(int id, Product product){
        product.setId(id);
        productRepository.save(product);
    }

    // удаляем товар по его id
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
