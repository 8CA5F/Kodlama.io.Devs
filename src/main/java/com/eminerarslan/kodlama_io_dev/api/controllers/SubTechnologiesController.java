package com.eminerarslan.kodlama_io_dev.api.controllers;

import com.eminerarslan.kodlama_io_dev.business.abstracts.SubTechnologyService;
import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.eminerarslan.kodlama_io_dev.core.utils.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sub-technologies")
public class SubTechnologiesController {
    SubTechnologyService subTechnologyService;

    @Autowired
    public SubTechnologiesController(SubTechnologyService subTechnologyService) {
        this.subTechnologyService = subTechnologyService;
    }

    @GetMapping
    Result getAll() {
        return subTechnologyService.getAll();
    }

    @PostMapping
    Result create(@Valid @RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
        return subTechnologyService.create(createSubTechnologyRequest);
    }

    @GetMapping("/{id}")
    Result getById(@PathVariable int id) {
        return subTechnologyService.getById(id);
    }

    @DeleteMapping("/{id}")
    Result deleteById(@PathVariable int id) {
        return subTechnologyService.deleteById(id);
    }

    @PutMapping("/{id}")
    Result updateById(@Valid @PathVariable int id, @RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) {
        return subTechnologyService.updateById(id, updateSubTechnologyRequest);
    }
}
