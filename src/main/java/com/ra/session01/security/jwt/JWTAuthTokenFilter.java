package com.ra.session01.security.jwt;


import com.ra.session01.model.entity.Student;
import com.ra.session01.security.principle.StudentDetailService;
import com.ra.session01.service.student.StudentService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JWTAuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private final JWTProvider jwtProvider;
    @Autowired
    private  final StudentDetailService studentDetailService;
    @Autowired
    private final StudentService studentService;
    public JWTAuthTokenFilter(JWTProvider jwtProvider, StudentDetailService studentDetailService, StudentService studentService) {
        this.jwtProvider = jwtProvider;
        this.studentDetailService = studentDetailService;
        this.studentService = studentService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                String token = getTokenFromRequest(request);
       try {
           if(token != null && jwtProvider.validateToken(token)){
               String username = jwtProvider.getUsernameFromToken(token);
               UserDetails userDetails = studentDetailService.loadUserByUsername(username);
               if(userDetails != null){
                   Student student = studentService.getStudentByUsername(username);
                   if(student != null && !student.is_deleted()){
                       UsernamePasswordAuthenticationToken authenticationToken
                               = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                       authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                       SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                   }else {
                       response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Student not login !");
                       return;
                   }
               }
           }
       }catch (DisabledException e) {
           logger.error("User is disabled: " + e.getMessage());
           response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User account is disabled.");
           return;
       } catch (Exception ex) {
           logger.error("Authentication failed: " + ex.getMessage());
           response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
           return;
       }
        filterChain.doFilter(request,response);
    }


    public String getTokenFromRequest(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")){
            return header.substring(7);
        }else {
            return null ;
        }
    }

}
