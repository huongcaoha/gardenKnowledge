package com.ra.session01.service.plantPot;

import com.ra.session01.model.entity.PlantPot;
import com.ra.session01.repository.PlantPotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlantPotService implements IPlantPotService{
    @Autowired
    private PlantPotRepository plantpotRepository;

    @Override
    public List<PlantPot> findAll() {
        try {
            return plantpotRepository.findAll();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PlantPot findById(Long id) {
        return plantpotRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found plant pot"));
    }

    @Override
    public PlantPot save(PlantPot plantPot) {
        try {
            return plantpotRepository.save(plantPot);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PlantPot update(PlantPot plantPot) {
        PlantPot plantPot1 = findById(plantPot.getId());
        if(plantPot1 != null){
            try {
                 return plantpotRepository.save(plantPot);
            }catch (Exception e){
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        PlantPot plantPot = findById(id);
        if (plantPot != null) {
            try {
                plantpotRepository.delete(plantPot);
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            return false;
        }
    }
}
