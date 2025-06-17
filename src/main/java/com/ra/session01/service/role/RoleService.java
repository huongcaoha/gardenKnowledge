package com.ra.session01.service.role;

import com.ra.session01.model.entity.Role;
import com.ra.session01.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService implements IRoleService  {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        try {
            return roleRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found role"));
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Not found role"));
    }

    @Override
    public Role save(Role role) {
        try {
           return roleRepository.save(role);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Role update(Role role) {
        Role role1 = findById(role.getId());
        if (role1 != null) {
            try {
              return   roleRepository.save(role);
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
       Role role = findById(id);
       if (role != null) {
           try {
               roleRepository.delete(role);
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
