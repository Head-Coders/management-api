package com.management.service;

import com.management.domain.Product;
import com.management.domain.Store;
import com.management.repository.ProductRepository;
import com.management.repository.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.service.StoreService;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    StoreRepository storeRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    // ATUALIZEI ISSO
    @Transactional
    public Product createProduct(Product product, Long storeId) {
        Optional<Store> optionalStore =  storeRepository.findById(storeId); // ATTUALIZEI ISSO
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();
            product.setStore(store);
            product.setCreateDate(LocalDateTime.now());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Não foi possível encontrar a loja com o ID fornecido: " + storeId);
        }
    }


    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get();
            productToUpdate.setName(productDetails.getName());
            productToUpdate.setDescription(productDetails.getDescription());
            productToUpdate.setUpdateDate(LocalDateTime.now());
            productToUpdate.setPrice(productDetails.getPrice());
            productToUpdate.setQuantity(productDetails.getQuantity());

            // Salva e retorna o produto atualizado
            return productRepository.save(productToUpdate);
        }
        return null; // Retorna null se o produto não for encontrado
    }



    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
