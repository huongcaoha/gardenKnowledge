package com.ra.session01.security.principle;

import com.ra.session01.model.entity.Student;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentPrinciple implements UserDetails {
    private Student student ;

    private Collection<? extends GrantedAuthority> authorities ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return student.getPassword();
    }

    @Override
    public String getUsername() {
        return student.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return student.is_deleted();
    }

}
