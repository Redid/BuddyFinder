package com.tai.service;

import com.tai.model.Timer;
import com.tai.repository.TimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by izabella on 25.05.16.
 */
@Component
public class ReadForTimer {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    TimerRepository timerRepository;


    public Iterable<Timer> searchAll(){
        return timerRepository.findAll();
    }

    public List<Timer> searchAllByDate(LocalDate localDate){ return timerRepository.findByDate(localDate);}
    public Timer searchOneByDate(LocalDate localDate){ return timerRepository.findOneByDate(localDate);}

    public List<Timer> searchAllByFrom(LocalTime from){ return timerRepository.findByFrom(from);}
    public Timer searchOneByFrom(LocalTime from){ return timerRepository.findOneByFrom(from);}

    public List<Timer> searchAllByTo(LocalTime to){ return timerRepository.findByTo(to);}
    public Timer searchOneByTo(LocalTime to){ return timerRepository.findOneByTo(to);}
}
