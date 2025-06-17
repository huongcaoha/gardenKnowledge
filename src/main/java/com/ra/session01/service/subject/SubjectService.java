package com.ra.session01.service.subject;

import com.ra.session01.model.entity.Subject;
import com.ra.session01.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        try {
            return subjectRepository.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found subject"));
    }

    @Override
    public Subject save(Subject subject) {
        try {
           return subjectRepository.save(subject);

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Subject update(Subject subject) {
        Subject subject1 = findById(subject.getId());
        if (subject1 != null) {
            try {
               return subjectRepository.save(subject);

            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
       Subject subject = findById(id);
       if (subject != null) {
           try {
               subjectRepository.delete(subject);
               return true;
           }catch (Exception e) {
               return false ;
           }
       }else {
           return false ;
       }
    }
}
