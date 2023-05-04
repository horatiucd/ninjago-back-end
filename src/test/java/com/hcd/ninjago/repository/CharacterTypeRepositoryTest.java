package com.hcd.ninjago.repository;

import com.hcd.ninjago.domain.CharacterType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CharacterTypeRepositoryTest {

    @Autowired
    private CharacterTypeRepository characterTypeRepo;

    @Test
    void findAll() {
        List<CharacterType> types = characterTypeRepo.findAll();
        Assertions.assertNotNull(types);
        Assertions.assertEquals(3, types.size());
    }
}
