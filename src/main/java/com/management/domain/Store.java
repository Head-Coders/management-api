package com.management.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // Indica que o CNPJ é unico e nao pode ser nulo
    private String CNPJ;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    private String description;
    private String phone;
    @Column(name = "create_date") // Especifica o nome da coluna
    private LocalDateTime createDate;

    @Column(name = "update_date") // Especifica o nome da coluna
    private LocalDateTime updateDate;
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL) // Define o relacionamento um para muitos com Product
    private List<Product> products; // Lista de produtos pertencentes a esta loja

}
