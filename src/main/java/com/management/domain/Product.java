package com.management.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data // Gera getters, setters, toString, equals e hashCode automaticamente
@Entity // Marca esta classe como uma entidade JPA (BD)
public class Product {

    @Id // Indica que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id;

    @Column(nullable = false) // Indica que esta coluna não pode ser nula
    private String name;

    private String description;

    @Column(nullable = false) // Indica que esta coluna não pode ser nula
    private BigDecimal price;

    @Column(nullable = false) // Indica que esta coluna não pode ser nula
    private int quantity;

    @Column(name = "create_date") // Especifica o nome da coluna
    private LocalDateTime createDate;

    @Column(name = "update_date") // Especifica o nome da coluna
    private LocalDateTime updateDate;
    @ManyToOne // Define o relacionamento muitos para um com Store
    @JoinColumn(name = "store_id", nullable = false) // Nome da coluna na tabela Product que referencia a Store
    private Store store; // Referência para a entidade Store
}
