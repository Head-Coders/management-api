package com.management.controller;

import com.management.domain.Category;
import com.management.dto.CategoryDTO;
import com.management.dto.mapper.CategoryMapper;
import com.management.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorys")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCages(){
       //Metodo resgatando todas as categorias e o Stream é para mapear cada categoria para DTO
        List<CategoryDTO> list=categoryService.getAllCages().stream().map(CategoryMapper::toDTO).toList();
        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody Category category){
        CategoryDTO dto = CategoryMapper.toDTO(categoryService.createCategory(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
