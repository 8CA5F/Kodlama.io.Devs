package com.eminerarslan.kodlama_io_dev.repository.concretes;

import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;
import com.eminerarslan.kodlama_io_dev.repository.abstracts.ProgrammingLanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<>();
        programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
        programmingLanguages.add(new ProgrammingLanguage(2, "Javascript"));
        programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
        programmingLanguages.add(new ProgrammingLanguage(4, "Python"));
        programmingLanguages.add(new ProgrammingLanguage(5, "Rust"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguages.stream().filter(programmingLanguage -> programmingLanguage.getId() == id).findFirst().orElse(null);
    }

    @Override
    public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage lastElement = programmingLanguages.get(programmingLanguages.size() - 1);
        programmingLanguage.setId(lastElement.getId() + 1);
        programmingLanguages.add(programmingLanguage);
        return programmingLanguage;
    }

    @Override
    public ProgrammingLanguage deleteById(int id) {
        ProgrammingLanguage toDelete = getById(id);
        programmingLanguages.removeIf(programmingLanguage -> programmingLanguage.getId() == id);
        return toDelete;
    }

    @Override
    public ProgrammingLanguage updateById(int id, String name) {
        ProgrammingLanguage programmingLanguage = getById(id);
        programmingLanguage.setName(name);
        return programmingLanguage;
    }
}
