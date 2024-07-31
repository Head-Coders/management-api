package com.management.service;

import com.management.domain.Category;
import com.management.dto.CategoryDTO;
import com.management.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getAllCages() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
