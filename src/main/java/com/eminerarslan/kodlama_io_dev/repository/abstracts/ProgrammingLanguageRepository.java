package com.eminerarslan.kodlama_io_dev.repository.abstracts;

import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {
    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id);

    ProgrammingLanguage create(ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage deleteById(int id);

    ProgrammingLanguage updateById(int id, String name);
}
