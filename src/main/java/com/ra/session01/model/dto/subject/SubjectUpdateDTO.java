package com.ra.session01.model.dto.subject;

import com.ra.session01.model.entity.Subject;
import com.ra.session01.validator.CheckNameExisted;
import com.ra.session01.validator.CheckNameUpdateExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SubjectUpdateDTO {
    @NotNull(message = "Can not null")
    private Long id;

    @NotBlank(message = "Can not blank")
    @CheckNameUpdateExist(entityClass = Subject.class,fieldName = "subjectName",oldName = "oldSubjectName")
    private String subjectName;

    @NotBlank(message = "Can not blank")
    private String oldSubjectName;
}
