package com.diegojacober.apilivros.domain.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books;

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
