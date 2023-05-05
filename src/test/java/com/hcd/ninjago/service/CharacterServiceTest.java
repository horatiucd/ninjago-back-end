package com.hcd.ninjago.service;

import com.hcd.ninjago.domain.Character;
import com.hcd.ninjago.domain.CharacterType;
import com.hcd.ninjago.domain.CharacterTypeName;
import com.hcd.ninjago.repository.CharacterRepository;
import com.hcd.ninjago.repository.CharacterTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CharacterServiceTest {

    @Autowired
    private CharacterTypeRepository characterTypeRepo;

    @Autowired
    private CharacterRepository characterRepo;

    private CharacterService service;

    private final Map<CharacterTypeName, CharacterType> nameToType = new HashMap<>();

    @BeforeEach
    public void setUp() {
        service = new CharacterService(characterRepo);

        characterTypeRepo.findAll()
                .forEach(type -> nameToType.put(CharacterTypeName.valueOf(type.getName().toUpperCase()), type));
    }

    @Test
    void findByPattern() {
        Character character1 = new Character();
        character1.setType(nameToType.get(CharacterTypeName.EVIL));
        character1.setName("B Abc 1");
        character1.setSeason(1);
        characterRepo.save(character1);

        Character character2 = new Character();
        character2.setType(nameToType.get(CharacterTypeName.GOOD));
        character2.setName("A abc 2");
        character2.setSeason(1);
        characterRepo.save(character2);

        Character character3 = new Character();
        character3.setType(nameToType.get(CharacterTypeName.NEUTRAL));
        character3.setName("C a bc 3");
        character3.setSeason(2);
        characterRepo.save(character3);

        final String pattern = "Abc";
        List<Character> characters = service.findByPattern(pattern);

        Assertions.assertNotNull(characters);
        Assertions.assertTrue(characters.size() >= 2);
        Assertions.assertTrue(characters.contains(character1) &&
                characters.contains(character2) &&
                !characters.contains(character3));
        Assertions.assertTrue(characters.indexOf(character2) < characters.indexOf(character1));
    }

    @Test
    void findByType() {
        Character character1 = new Character();
        character1.setType(nameToType.get(CharacterTypeName.EVIL));
        character1.setName("B Abc 1");
        character1.setSeason(1);
        characterRepo.save(character1);

        Character character2 = new Character();
        character2.setType(nameToType.get(CharacterTypeName.EVIL));
        character2.setName("A abc 2");
        character2.setSeason(1);
        characterRepo.save(character2);

        final long typeId = nameToType.get(CharacterTypeName.EVIL).getId();

        List<Character> characters = service.findByTypeId(typeId);
        Assertions.assertNotNull(characters);
        Assertions.assertTrue(characters.size() >= 2);
        Assertions.assertTrue(characters.contains(character1) &&
                characters.contains(character2));
        Assertions.assertTrue(characters.indexOf(character2) < characters.indexOf(character1));
    }
}
