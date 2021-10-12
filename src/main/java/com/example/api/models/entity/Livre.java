package com.example.api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Table(name = "Livre")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livre {
    @Id
    @Column(name ="isbn", nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double prix;

    @ManyToMany
    private Set<Auteur> auteurs;

}
