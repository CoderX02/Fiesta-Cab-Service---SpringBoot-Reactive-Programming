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
@Document("driver")
public class Driver{
    @Id
    private String driverId;
    private String driverName;
    private Subsidiary driverSubsidiary;
    private Boolean isAssigned;
}
