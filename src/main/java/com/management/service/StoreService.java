package com.management.service;

import com.management.domain.Product;
import com.management.domain.Store;
import com.management.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

    public Store createStore(@RequestBody Store store) {
        store.setCreateDate(LocalDateTime.now());
        return storeRepository.save(store);
    }

    public Store updateStore(Long id, Store storeDetails) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();
            store.setCNPJ(storeDetails.getCNPJ());
            store.setName(storeDetails.getName());
            store.setDescription(storeDetails.getDescription());
            store.setPhone(storeDetails.getPhone());
            store.setUpdateDate(LocalDateTime.now());
            return storeRepository.save(store);
        }
        return null;
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    public Store createStoreWithProducts(Store store, List<Product> products) {
        store.setCreateDate(LocalDateTime.now());
        store.setProducts(products); // Associando os produtos à loja

        // Salvando a loja e seus produtos
        return storeRepository.save(store);
    }


}
