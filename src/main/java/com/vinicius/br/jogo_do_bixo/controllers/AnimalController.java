package com.vinicius.br.jogo_do_bixo.controllers;

import com.vinicius.br.jogo_do_bixo.models.animals.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("v1/animal")
@SecurityRequirement(name = "bearer-key")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SorteioDeAnimais sorteioDeAnimais;

    @PostMapping
    @Transactional
    public ResponseEntity registerAnimal(@RequestBody  @Valid AnimalRegisterDTO dto, UriComponentsBuilder uriBuilder){
        return sorteioDeAnimais.save(dto,uriBuilder);
    }


    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        var animal = animalRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailAnimalDTO(animal));
    }


    @GetMapping("/random")
    @Transactional
    public ResponseEntity getRandom(){
        var animal = animalRepository.findRandomAnimal();
        return ResponseEntity.ok(sorteioDeAnimais.draw(animal));
    }

    @GetMapping()
    public ResponseEntity getAll(@PageableDefault(size = 20,sort = {"nome"}) Pageable pageable){
        var animals = animalRepository.findAll(pageable).map(DetailAnimalDTO::new);
        return ResponseEntity.ok(animals);
    }

}
