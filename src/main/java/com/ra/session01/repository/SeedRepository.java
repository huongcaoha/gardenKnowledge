package com.ra.session01.repository;

import com.ra.session01.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Question,Long> {
}
