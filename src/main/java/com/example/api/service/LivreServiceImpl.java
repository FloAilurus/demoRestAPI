package com.example.api.service;

import com.example.api.mapper.LivreMapper;
import com.example.api.models.dto.LivreDTO;
import com.example.api.repository.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreServiceImpl implements LivreService{

    private final LivreMapper mapper;
    private final LivreRepository repository;

    public LivreServiceImpl(LivreMapper mapper, LivreRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<LivreDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
