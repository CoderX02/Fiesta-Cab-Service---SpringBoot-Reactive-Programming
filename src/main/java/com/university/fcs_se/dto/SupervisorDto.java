package com.university.fcs_se.dto;

import com.university.fcs_se.entity.Subsidiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorDto {
    private String supervisorId;
    private String name;
    private Subsidiary subsidiary;
}
