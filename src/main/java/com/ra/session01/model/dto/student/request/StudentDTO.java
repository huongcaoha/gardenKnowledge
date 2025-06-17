package com.ra.session01.model.dto.student.request;

import com.ra.session01.model.entity.Student;
import com.ra.session01.validator.CheckFileEmpty;
import com.ra.session01.validator.CheckNameExisted;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {
    @NotBlank(message = "Can not blank")
    @CheckNameExisted(entityClass = Student.class,fieldName = "username")
    private String username ;

    @NotBlank(message = "Can not blank")
    @Email
    @CheckNameExisted(entityClass = Student.class,fieldName = "email")
    private String email;

    @NotBlank(message = "Can not blank")
    private String fullName ;

    @NotBlank(message = "Can not blank")
    private String password;

    @CheckFileEmpty
    private MultipartFile avatar;

    @NotNull(message = "Can not null")
    private long classsId ;

    @NotBlank(message = "Can not blank")
    @CheckNameExisted(entityClass = Student.class,fieldName = "phone")
    private String phone ;


}
