package com.hcd.ninjago.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.io.Serializable;

@Entity
@Table(name = "character", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" })})
@SequenceGenerator(sequenceName = "character_seq", name = "CUSTOM_SEQ_GENERATOR", allocationSize = 1)
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CUSTOM_SEQ_GENERATOR")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_fk", nullable = false)
    private CharacterType type;

    @Column(name = "season", nullable = false)
    private Integer season;

    @Column(name = "favorite")
    private Boolean favorite;

    public Character() {
        favorite = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}
