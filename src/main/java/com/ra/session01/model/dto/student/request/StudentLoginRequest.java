package com.ra.session01.model.dto.student.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentLoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
