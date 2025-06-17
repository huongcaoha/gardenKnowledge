package com.ra.session01.security.principle;

import com.ra.session01.model.entity.Student;
import com.ra.session01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDetailService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.getStudentByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Tạo danh sách authorities
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(student.getRole().getName()));

        // Khởi tạo StudentPrinciple
        return StudentPrinciple.builder()
                .student(student)
                .authorities(authorities)
                .build();
    }
}
