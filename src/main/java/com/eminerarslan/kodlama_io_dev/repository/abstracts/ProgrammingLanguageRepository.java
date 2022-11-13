package com.eminerarslan.kodlama_io_dev.repository.abstracts;

import com.eminerarslan.kodlama_io_dev.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
}
