package com.hcd.ninjago.controller;

import com.hcd.ninjago.domain.Character;
import com.hcd.ninjago.service.CharacterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
@CrossOrigin(origins = "http://localhost:4200")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getCharacters() {
        return characterService.getCharacters();
    }
}
