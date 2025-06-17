package com.ra.session01.model.dto.student.response;

import com.ra.session01.model.entity.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentLoginResponse {
    private String token;
    private String username;
    private String typeToken;
    private Role role ;
}
