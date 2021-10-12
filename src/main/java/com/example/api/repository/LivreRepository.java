package com.example.api.repository;

import com.example.api.models.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, String> {

}
