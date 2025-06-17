package com.ra.session01.model.dto.subject;

import com.ra.session01.model.entity.Subject;
import com.ra.session01.validator.CheckNameExisted;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SubjectDTO {
    @NotBlank(message = "Can not blank")
    @CheckNameExisted(entityClass = Subject.class, fieldName = "subjectName")
    private String subjectName;
}
