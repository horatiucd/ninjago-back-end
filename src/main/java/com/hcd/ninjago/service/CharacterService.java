package com.hcd.ninjago.service;

import com.hcd.ninjago.domain.Character;
import com.hcd.ninjago.domain.QCharacter;
import com.hcd.ninjago.repository.CharacterRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CharacterService {

    private final CharacterRepository characterRepo;

    public CharacterService(CharacterRepository characterRepo) {
        this.characterRepo = characterRepo;
    }

    public List<Character> getCharacters() {
        return characterRepo.findAll();
    }

    public List<Character> findByPattern(String pattern) {
        Objects.requireNonNull(pattern);

        final Predicate predicate = QCharacter.character.name.containsIgnoreCase(pattern);
        final OrderSpecifier<String> orderBy = QCharacter.character.name.asc();

        List<Character> result = new ArrayList<>();
        characterRepo.findAll(predicate, orderBy)
                .forEach(result::add);
        return result;
    }

    public List<Character> findByTypeId(long typeId) {
        final Predicate predicate = QCharacter.character.type.id.eq(typeId);
        final OrderSpecifier<String> orderBy = QCharacter.character.name.asc();

        List<Character> result = new ArrayList<>();
        characterRepo.findAll(predicate, orderBy)
                .forEach(result::add);
        return result;
    }
}
