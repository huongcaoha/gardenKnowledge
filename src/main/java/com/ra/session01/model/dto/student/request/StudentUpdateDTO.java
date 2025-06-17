package com.ra.session01.model.dto.student.request;

import com.ra.session01.model.entity.Student;
import com.ra.session01.validator.CheckNameUpdateExist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentUpdateDTO {
    @NotNull
    private long id ;

    @NotBlank(message = "Can not blank")
    @CheckNameUpdateExist(entityClass = Student.class , fieldName = "username",oldName = "oldUsername" )
    private String username ;

    @NotBlank
    private String oldUsername ;

    @NotBlank(message = "Can not blank")
    @Email
    @CheckNameUpdateExist(entityClass = Student.class , fieldName = "email",oldName = "oldEmail" )
    private String email;

    @NotBlank
    private String oldEmail ;

    @NotBlank(message = "Can not blank")
    private String fullName ;

    @NotBlank(message = "Can not blank")
    private String password;

    @NotBlank(message = "Can not blank")
    private String avatar;

    @NotNull(message = "Can not null")
    private long classsId ;

    @NotBlank(message = "Can not blank")
    @CheckNameUpdateExist(entityClass = Student.class , fieldName = "phone",oldName = "oldPhone" )
    private String phone ;

    @NotBlank
    private String oldPhone ;
}

