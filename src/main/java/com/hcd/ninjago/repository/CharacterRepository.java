package com.hcd.ninjago.repository;

import com.hcd.ninjago.domain.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends BaseRepository<Character, Long> {
}
