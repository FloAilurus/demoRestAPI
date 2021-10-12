package com.example.api.utils;

import com.example.api.models.entity.Auteur;
import com.example.api.models.entity.Livre;
import com.example.api.repository.AuteurRepository;
import com.example.api.repository.LivreRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean {

    private final LivreRepository lRep;
    private final AuteurRepository aRep;

    public DatabaseFiller(LivreRepository lRep, AuteurRepository aRep) {
        this.lRep = lRep;
        this.aRep = aRep;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Auteur a = new Auteur();
        a.setNom("dubois");
        a.setPrenom("pol");

        a = aRep.save(a);

        Livre l1 = new Livre();
    }
}
