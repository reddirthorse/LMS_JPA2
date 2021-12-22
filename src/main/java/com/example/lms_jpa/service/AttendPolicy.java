package com.example.lms_jpa.service;

import com.example.lms_jpa.domain.Attend;
import com.example.lms_jpa.domain.AttendStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
@Transactional
public class AttendPolicy {
    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
    Date startTime = dateFormat.parse("09:00:00");
    Date endTime = dateFormat.parse("16:50:00");

    @Autowired
    public AttendPolicy() throws ParseException {
    }

    public AttendStatus JudgeAttend(Attend attend) {
        if (attend.getEnter_datetime().compareTo(startTime)<=0 && attend.getLeft_dateTime().compareTo(endTime)>=0){
            return AttendStatus.ATTEND;
        }
        if (attend.getEnter_datetime().compareTo(startTime)>0 && attend.getLeft_dateTime().compareTo(endTime)>=0){
            return AttendStatus.LATE;
        }
        if (attend.getLeft_dateTime().compareTo(endTime)<=0){
            return AttendStatus.EARLYLEFT;
        }
        else return AttendStatus.ABSENT;
    }
}
