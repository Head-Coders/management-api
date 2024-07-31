package com.management.dto.mapper;

import com.management.domain.Category;
import com.management.dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
    public static Category toEntity(CategoryDTO category){
        return Category.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
//classe utilizada para mapeamento / transformar entidade em DTO e vice versa