package com.example.api.mapper;

import com.example.api.form.LivreForm;
import com.example.api.form.LivreUpdateForm;
import com.example.api.models.dto.LivreDTO;
import com.example.api.models.entity.Auteur;
import com.example.api.models.entity.Livre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class LivreMapper {

    public LivreDTO toDTO(Livre entity) {

        if (entity == null)
            return null;

        return LivreDTO.builder()
                .isbn(entity.getIsbn())
                .titre(entity.getTitre())
                .prix(entity.getPrix())
                .auteurs(
                        entity.getAuteurs()
                            .stream()
                            .map(this::toInnerDto)
                            .collect(Collectors.toList())
                )
                .build();
    }

    public Livre formtoEntity(LivreForm form) {
        if (form == null)
            return null;

        Livre l = new Livre();
        l.setIsbn(form.getIsbn());
        l.setTitre(form.getTitre());
        l.setPrix(form.getPrix());

        return l;
    }

    public Livre updateFormToEntity(LivreUpdateForm form) {
        if (form == null)
            return null;

        Livre l = new Livre();
        l.setTitre(form.getTitre());
        l.setPrix(form.getPrix());

        return l;
    }

    private LivreDTO.AuteurDTO toInnerDto(Auteur auteur) {
        if (auteur == null)
            return null;

        return LivreDTO.AuteurDTO.builder()
                .id(auteur.getId())
                .nom(auteur.getNom())
                .prenom(auteur.getPrenom())
                .build();
    }
}
