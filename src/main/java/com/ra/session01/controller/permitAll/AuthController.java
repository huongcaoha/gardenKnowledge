package com.ra.session01.controller.permitAll;

import com.ra.session01.model.dto.student.request.StudentDTO;
import com.ra.session01.model.dto.student.request.StudentLoginRequest;
import com.ra.session01.model.dto.student.response.StudentLoginResponse;
import com.ra.session01.model.entity.Student;
import com.ra.session01.service.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api.GardenOfKnowledge.com/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<StudentLoginResponse> login(@Valid @ModelAttribute StudentLoginRequest studentLoginRequest) {
        return new ResponseEntity<>(authService.login(studentLoginRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Student> register(@Valid @ModelAttribute StudentDTO studentDTO) throws IOException {
        return new ResponseEntity<>(authService.registerStudent(studentDTO),HttpStatus.CREATED);
    }
}
