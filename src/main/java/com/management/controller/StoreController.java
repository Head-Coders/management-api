package com.management.controller;


import com.management.domain.Store;
import com.management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")

public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Store> updatedStore (@PathVariable Long id, @RequestBody Store storeDetails){
        Store updateStore = storeService.updateStore(id,storeDetails);
        if (updateStore != null) {
            return ResponseEntity.ok(updateStore);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteStore (@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }



}

