package com.ra.session01.service.student;

import com.ra.session01.model.entity.Student;
import com.ra.session01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByUsername(String username){
        return studentRepository.getStudentByUsername(username);
    }

    @Override
    public List<Student> findAll() {
        try {
            return studentRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found student"));
    }

    @Override
    public Student save(Student student) {
        try {
           return studentRepository.save(student);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student update(Student student) {
        Student student1 = findById(student.getId());
        if(student1 != null){
            try {
               return studentRepository.save(student);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }else {
            return null;

        }
    }

    @Override
    public boolean delete(Long id) {
        Student student1 = findById(id);
        if(student1 != null){
            try {
                studentRepository.delete(student1);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }else {
            return false;

        }
    }
}
