package com.tai.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "Timer")
public class Timer {
    private LocalDate date;
    private LocalTime from;
    private LocalTime to;

    public Timer(LocalDate date, LocalTime from, LocalTime to){
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public LocalDate getDate(){
        return date;
    }

    public LocalTime getFrom(){
        return from;
    }

    public LocalTime getTo(){
        return to;
    }
}
