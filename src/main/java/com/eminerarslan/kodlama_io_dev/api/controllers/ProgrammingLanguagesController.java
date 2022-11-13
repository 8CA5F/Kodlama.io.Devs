package com.eminerarslan.kodlama_io_dev.api.controllers;

import com.eminerarslan.kodlama_io_dev.business.abstracts.ProgrammingLanguageService;
import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    Result getById(@PathVariable int id) {
        return programmingLanguageService.getById(id);
    }

    @PostMapping
    Result create(@Valid @RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        return programmingLanguageService.create(createProgrammingLanguageRequest);
    }

    @DeleteMapping("/{id}")
    Result deleteById(@PathVariable int id) {
        return programmingLanguageService.deleteById(id);
    }

    @PutMapping("/{id}")
    Result updateById(@Valid @PathVariable int id, @RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        return programmingLanguageService.updateById(id, updateProgrammingLanguageRequest);
    }
}
