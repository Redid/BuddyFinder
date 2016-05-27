package com.tai.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "Timer")
public class Timer {
    private LocalDate date;
    private LocalTime from;
    private LocalTime to;

    public Timer(){}

    public Timer(LocalDate date, LocalTime from, LocalTime to){
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){this.date = date;}
    public LocalTime getFrom(){
        return from;
    }
    public void setFrom(LocalTime from){this.from = from;}
    public LocalTime getTo(){
        return to;
    }
    public void setTo(LocalTime to){this.to = to;}


}
