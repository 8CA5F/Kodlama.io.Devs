package com.eminerarslan.kodlama_io_dev.api.controllers;

import com.eminerarslan.kodlama_io_dev.business.abstracts.ProgrammingLanguageService;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/programming-languages")
public class ProgrammingLanguagesController {
    ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    Result getAll() {
        return this.programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    Result getById(@PathVariable int id) {
        return this.programmingLanguageService.getById(id);
    }

    @PostMapping
    Result create(@RequestBody ProgrammingLanguage programmingLanguage) {
        return this.programmingLanguageService.create(programmingLanguage);
    }

    @DeleteMapping("/{id}")
    Result deleteById(@PathVariable int id) {
        return this.programmingLanguageService.deleteById(id);
    }

    @PutMapping("/{id}")
    Result updateById(@PathVariable int id, @RequestBody ProgrammingLanguage programmingLanguage) {
        return this.programmingLanguageService.updateById(id, programmingLanguage.getName());
    }
}
