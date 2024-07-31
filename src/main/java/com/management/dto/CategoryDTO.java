package com.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {
    private Long id;

    private String name;

    private String description;
}
//DTO é um conceito usado para evitar recursividade