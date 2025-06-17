package com.ra.session01.model.dto.answer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AnswerDTO {
    @NotBlank
    private String answer ;

    @NotNull
    private boolean status ;
}
