package com.eminerarslan.kodlama_io_dev.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name = "programming_languages")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 1, max = 15, message = "Programming language size must be between 1-15")
    @NotNull(message = "Name is required")
    private String name;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<SubTechnology> subTechnologies;
}
