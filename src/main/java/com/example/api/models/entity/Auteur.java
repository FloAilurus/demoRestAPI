package com.example.api.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "Auteur")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @ManyToMany(mappedBy = "auteurs")
    private Set<Livre> livres;
}
