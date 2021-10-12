package com.example.api.service;

import com.example.api.form.LivreForm;
import com.example.api.form.LivreUpdateForm;
import com.example.api.mapper.LivreMapper;
import com.example.api.models.dto.LivreDTO;
import com.example.api.models.entity.Auteur;
import com.example.api.models.entity.Livre;
import com.example.api.repository.AuteurRepository;
import com.example.api.repository.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LivreServiceImpl implements LivreService{

    private final LivreMapper mapper;
    private final LivreRepository repository;
    private final AuteurRepository auteurRepository;

    public LivreServiceImpl(LivreMapper mapper, LivreRepository repository, AuteurRepository auteurRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.auteurRepository = auteurRepository;
    }


    @Override
    public List<LivreDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivreDTO getOne(String isbn) {
        return repository.findById(isbn)
                .map(mapper::toDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public LivreDTO insert(LivreForm form) {

        if (repository.existsById(form.getIsbn()))
            throw new RuntimeException();

        Livre toInsert = mapper.formtoEntity(form);
        Set<Auteur> auteurs = form.getAuteurIds()
                .stream()
                .map(id -> auteurRepository.findById(id).orElseThrow(RuntimeException::new))
                .collect(Collectors.toSet());

        toInsert.setAuteurs(auteurs);

        //TODO

        return mapper.toDTO(toInsert);
    }

    @Override
    public LivreDTO delete(String isbn) {

        Livre toDelete = repository.findById(isbn)
                .orElseThrow(RuntimeException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public LivreDTO update(String isbn, LivreUpdateForm form) {

        Livre toUpdate = repository.findById(isbn)
                .orElseThrow(RuntimeException::new);

        toUpdate.setPrix(form.getPrix());
        toUpdate.setTitre(form.getTitre());
        Set<Auteur> auteurs = form.getAuteurIds()
                .stream()
                .map(id -> auteurRepository.findById(id).orElseThrow(RuntimeException::new))
                .collect(Collectors.toSet());
        toUpdate.setAuteurs(auteurs);

        //TODO

        return mapper.toDTO(toUpdate);
    }


}
