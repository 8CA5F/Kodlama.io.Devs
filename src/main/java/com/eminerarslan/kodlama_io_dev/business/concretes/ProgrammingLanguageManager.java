package com.eminerarslan.kodlama_io_dev.business.concretes;

import com.eminerarslan.kodlama_io_dev.business.abstracts.ProgrammingLanguageService;
import com.eminerarslan.kodlama_io_dev.core.utils.results.ErrorResult;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import com.eminerarslan.kodlama_io_dev.core.utils.results.SuccessDataResult;
import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;
import com.eminerarslan.kodlama_io_dev.repository.abstracts.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public Result getAll() {
        return new SuccessDataResult<>(this.programmingLanguageRepository.getAll());
    }

    @Override
    public Result getById(int id) {
        return new SuccessDataResult<>(this.programmingLanguageRepository.getById(id));
    }

    @Override
    public Result create(ProgrammingLanguage programmingLanguage) {
        if (programmingLanguage.getName().length() > 0) {
            for (ProgrammingLanguage language : this.programmingLanguageRepository.getAll()) {
                if (language.getName().equalsIgnoreCase(programmingLanguage.getName())) {
                    return new ErrorResult("Programming languages must be unique");
                }
            }
            return new SuccessDataResult<>(this.programmingLanguageRepository.create(programmingLanguage));
        }
        return new ErrorResult("Programming language cannot be empty");
    }

    @Override
    public Result deleteById(int id) {
        ProgrammingLanguage deletedProgrammingLanguage = this.programmingLanguageRepository.deleteById(id);
        return new SuccessDataResult<>(deletedProgrammingLanguage, deletedProgrammingLanguage.getName() + " deleted");
    }

    @Override
    public Result updateById(int id, String name) {
        return new SuccessDataResult<>(this.programmingLanguageRepository.updateById(id, name));
    }
}
