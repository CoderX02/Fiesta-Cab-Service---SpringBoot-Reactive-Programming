package com.university.fcs_se.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("supervisor")
public class Supervisor {
    @Id
    private String supervisorId;
    private String name;
    private Subsidiary subsidiary;
}
