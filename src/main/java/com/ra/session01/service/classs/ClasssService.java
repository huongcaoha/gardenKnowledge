package com.ra.session01.service.classs;

import com.ra.session01.model.entity.Classs;
import com.ra.session01.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClasssService implements IClasssService {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Classs> findAll() {
        try {
            return classRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Classs findById(Long id) {
        return (Classs) classRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not found class"));
    }

    @Override
    public Classs save(Classs classs) {
        try {
            return classRepository.save(classs);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Classs update(Classs classs) {
        Classs classs1 = findById(classs.getId());
        if(classs1 != null){
            try {
                return classRepository.save(classs);
            }catch (Exception e){
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        Classs classs = findById(id);
        if(classs != null){
            try {
                classRepository.delete(classs);
                return true;
            }catch (Exception e){
                return false;
            }
        }else {

            return false;
        }
    }
}
