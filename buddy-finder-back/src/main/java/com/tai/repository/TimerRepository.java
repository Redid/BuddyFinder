package com.tai.repository;

import com.tai.model.Timer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by izabella on 25.05.16.
 */
public interface TimerRepository extends MongoRepository<Timer, String> {
    Timer findOneByDate(LocalDate date);
    List<Timer> findByDate(LocalDate date);

    Timer findOneByFrom(LocalTime from);
    List<Timer> findByFrom(LocalTime from);
    Timer findOneByTo(LocalTime to);
    List<Timer> findByTo(LocalTime to);

}
