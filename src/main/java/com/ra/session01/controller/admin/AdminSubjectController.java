package com.ra.session01.controller.admin;

import com.ra.session01.exception.CustomException;
import com.ra.session01.model.dto.subject.SubjectDTO;
import com.ra.session01.model.dto.subject.SubjectUpdateDTO;
import com.ra.session01.model.entity.Subject;
import com.ra.session01.service.subject.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api.GardenOfKnowledge.com/v1/admin/subjects")
public class AdminSubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long id) {
        return new ResponseEntity<>(subjectService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@Valid @RequestBody SubjectDTO subjectDTO)  {
        Subject subject = new Subject();
        subject.setSubjectName(subjectDTO.getSubjectName());
        return new ResponseEntity<>(subjectService.save(subject),HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Subject> updateSubject(@Valid @RequestBody SubjectUpdateDTO subjectUpdateDTO) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectUpdateDTO.getSubjectName());
        subject.setId(subjectUpdateDTO.getId());
        return new ResponseEntity<>(subjectService.update(subject),HttpStatus.OK);
    }
}
