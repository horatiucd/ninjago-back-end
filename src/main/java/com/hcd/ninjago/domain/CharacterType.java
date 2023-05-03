package com.hcd.ninjago.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.io.Serializable;

@Entity
@Table(name = "character_type", uniqueConstraints = { @UniqueConstraint(columnNames = {"name"})} )
@SequenceGenerator(sequenceName = "character_type_seq", name = "CUSTOM_SEQ_GENERATOR", allocationSize = 1)
public class CharacterType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CUSTOM_SEQ_GENERATOR")
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public CharacterType() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
