package com.ra.session01.service.plantPotStudent;

import com.ra.session01.model.entity.PlantPotStudent;
import com.ra.session01.repository.PlantPotStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlantPotStudentService implements IPlantPotStudentService{
    @Autowired
    private PlantPotStudentRepository plantPotStudentRepository ;

    @Override
    public List<PlantPotStudent> findAll() {
        try {
            return plantPotStudentRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PlantPotStudent findById(Long id) {
        return plantPotStudentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found plant pot student"));
    }

    @Override
    public PlantPotStudent save(PlantPotStudent plantPotStudent) {
        try {
           return plantPotStudentRepository.save(plantPotStudent);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PlantPotStudent update(PlantPotStudent plantPotStudent) {
       PlantPotStudent plantPotStudent1 = findById(plantPotStudent.getId());
       if (plantPotStudent1 != null) {
           try {
              return plantPotStudentRepository.save(plantPotStudent);
           }catch (Exception e){
               return null ;
           }
       }else {
           return null;
       }
    }

    @Override
    public boolean delete(Long id) {
        PlantPotStudent plantPotStudent = findById(id);
        if(plantPotStudent != null) {
            try {
                plantPotStudentRepository.delete(plantPotStudent);
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            return false;
        }
    }
}
