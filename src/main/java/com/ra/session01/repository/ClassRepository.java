package com.ra.session01.repository;

import com.ra.session01.model.entity.Classs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Classs, Integer> {
    Optional<Object> findById(Long id);
}
