package com.example.api.controllers;

import com.example.api.form.LivreForm;
import com.example.api.models.dto.LivreDTO;
import com.example.api.service.LivreService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/livre")
public class LivreController {

    private final LivreService service;

    public LivreController(LivreService service) {
        this.service = service;
    }

//    GET http://localhost:8080/livre/all
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @GetMapping(path = {"/all", "", "/"})
    public List<LivreDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{isbn}")
    public LivreDTO getOne(@PathVariable String isbn) {
        return service.getOne(isbn);
    }
//  GET http://locaclhost:8080/livre?isbn={valeur}
    @GetMapping(params = {"isbn"})
    public LivreDTO getOneByParam(@RequestParam String isbn) {
        return service.getOne(isbn);
    }

    @PostMapping(path = {"", "/", "/add"})
    public LivreDTO insert(@Valid @RequestBody LivreForm form, @RequestHeader HttpHeaders headers) {

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key));
        }

        return service.insert(form);
    }
}
