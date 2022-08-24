package com.university.fcs_se.utils;

import com.university.fcs_se.dto.DriverDto;
import com.university.fcs_se.dto.SupervisorDto;
import com.university.fcs_se.entity.Driver;
import com.university.fcs_se.entity.Supervisor;
import org.springframework.beans.BeanUtils;

public class SupervisorAppUtils {
    public static SupervisorDto entityToDTo(Supervisor supervisor){
        SupervisorDto supervisorDto = new SupervisorDto();
        BeanUtils.copyProperties(supervisor,supervisorDto);
        return supervisorDto;
    }

    public static Supervisor dtoToEntity(SupervisorDto supervisorDto){
        Supervisor supervisor = new Supervisor();
        BeanUtils.copyProperties(supervisorDto,supervisor);
        return supervisor;
    }
}
