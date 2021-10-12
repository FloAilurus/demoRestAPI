package com.example.api.service;

import com.example.api.models.dto.LivreDTO;
import com.example.api.models.entity.Livre;

import java.util.List;

public interface LivreService {

    List<LivreDTO> getAll();

    LivreDTO getOne(String isbn);
}
