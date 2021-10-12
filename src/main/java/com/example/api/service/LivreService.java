package com.example.api.service;

import com.example.api.form.LivreForm;
import com.example.api.form.LivreUpdateForm;
import com.example.api.models.dto.LivreDTO;
import com.example.api.models.entity.Livre;

import java.util.List;

public interface LivreService {

    List<LivreDTO> getAll();

    LivreDTO getOne(String isbn);

    LivreDTO insert(LivreForm form);

    LivreDTO delete(String isbn);

    LivreDTO update(String isbn, LivreUpdateForm form);
}
