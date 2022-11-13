package com.eminerarslan.kodlama_io_dev.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "sub_technologies")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 2, max = 15, message = "Sub technology size must be between 2-15")
    @NotNull(message = "Name is required")
    private String name;

    @JoinColumn(name = "programming_language_id")
    @ManyToOne(cascade = CascadeType.DETACH)
    private ProgrammingLanguage programmingLanguage;
}
