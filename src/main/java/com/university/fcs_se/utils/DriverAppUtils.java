package com.university.fcs_se.utils;

import com.university.fcs_se.dto.DriverDto;
import com.university.fcs_se.entity.Driver;
import org.springframework.beans.BeanUtils;

public class DriverAppUtils {

    public static DriverDto entityToDTo(Driver driver){
        DriverDto driverDto = new DriverDto();
        BeanUtils.copyProperties(driver,driverDto);
        return driverDto;
    }

    public static Driver dtoToEntity(DriverDto driverDto){
        Driver driver = new Driver();
        BeanUtils.copyProperties(driverDto,driver);
        return driver;
    }
}
