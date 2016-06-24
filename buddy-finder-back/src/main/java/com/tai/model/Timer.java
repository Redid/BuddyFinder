package com.tai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Document(collection = "Timer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timer {
    @Id
    private String id;

    private LocalDate date;
    private LocalTime from;
    private LocalTime to;

    public Timer(LocalDate date, LocalTime from, LocalTime to) {
        this.date = date;
        this.from = from;
        this.to = to;
    }
}
