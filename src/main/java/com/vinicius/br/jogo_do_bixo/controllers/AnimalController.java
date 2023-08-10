package com.vinicius.br.jogo_do_bixo.controllers;

import com.vinicius.br.jogo_do_bixo.models.animals.Animal;
import com.vinicius.br.jogo_do_bixo.models.animals.AnimalRegisterDTO;
import com.vinicius.br.jogo_do_bixo.models.animals.AnimalRepository;
import com.vinicius.br.jogo_do_bixo.models.animals.DetailAnimalDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("v1/animal")
@SecurityRequirement(name = "bearer-key")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerAnimal(@RequestBody  @Valid AnimalRegisterDTO dto, UriComponentsBuilder uriBuilder){
        var animal = new Animal(dto);
        var uri = uriBuilder.path("/v1/animal/{id}").buildAndExpand(animal.getId()).toUri();
        animalRepository.save(animal);
        return ResponseEntity.created(uri).body(new DetailAnimalDTO(animal));
    }


    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        var animal = animalRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailAnimalDTO(animal));
    }


}
