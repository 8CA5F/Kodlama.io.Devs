package com.eminerarslan.kodlama_io_dev.business.abstracts;

import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
    Result getAll();

    Result getById(int id);

    Result create(ProgrammingLanguage programmingLanguage);

    Result deleteById(int id);

    Result updateById(int id, String name);
}
