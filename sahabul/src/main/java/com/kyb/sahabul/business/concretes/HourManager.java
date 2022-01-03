package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.HourServices;
import com.kyb.sahabul.dataAccess.abstracts.HourDao;
import com.kyb.sahabul.entities.concretes.Hour;
import org.springframework.stereotype.Service;

@Service
public class HourManager implements HourServices {
    private final HourDao hourDao;

    public HourManager(HourDao hourDao) {
        this.hourDao = hourDao;
    }


    @Override
    public Hour findById(int id) {
        return hourDao.getOne(id);
    }
}
