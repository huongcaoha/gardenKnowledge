package com.ra.session01.service.auth;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ra.session01.commonMethod.Common;
import com.ra.session01.model.dto.student.request.StudentDTO;
import com.ra.session01.model.dto.student.request.StudentLoginRequest;
import com.ra.session01.model.dto.student.response.StudentLoginResponse;
import com.ra.session01.model.entity.Classs;
import com.ra.session01.model.entity.Role;
import com.ra.session01.model.entity.Student;
import com.ra.session01.security.jwt.JWTProvider;
import com.ra.session01.security.principle.StudentPrinciple;
import com.ra.session01.service.classs.ClasssService;
import com.ra.session01.service.role.RoleService;
import com.ra.session01.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

@Service
public class AuthService {

    Common common = new Common();
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClasssService classsService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private RoleService roleService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JWTProvider jwtProvider;

    public StudentLoginResponse login(StudentLoginRequest studentLoginRequest) {
        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(studentLoginRequest.getUsername(),studentLoginRequest.getPassword()));
        StudentPrinciple studentPrinciple = (StudentPrinciple) authentication.getPrincipal();
        Student student = studentPrinciple.getStudent();
        String token = jwtProvider.generateToken(studentPrinciple);
        return StudentLoginResponse.builder()
                .username(student.getUsername())
                .role(student.getRole())
                .token(token)
                .typeToken("Bearer ")
                .build();
    }

    public Student registerStudent(StudentDTO studentDTO) throws IOException {
        Role role = roleService.getRoleByName("STUDENT");

        Student student = convertStudentDTOToStudent(studentDTO, role);
        String image = common.uploadImage(studentDTO.getAvatar());
        student.setAvatar(image);
        return studentService.save(student);
    }

    private Student convertStudentDTOToStudent(StudentDTO studentDTO, Role role) {
        return Student.builder()
                .username(studentDTO.getUsername())
                .password(passwordEncoder.encode(studentDTO.getPassword()))
                .role(role)
                .email(studentDTO.getEmail())
                .phone(studentDTO.getPhone())
                .fullName(studentDTO.getFullName())
                .classs(classsService.findById(studentDTO.getClasssId()))
                .build();
    }


}
