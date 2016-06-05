package com.tai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "Timer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timer {
    private LocalDate date;
    private LocalTime from;
    private LocalTime to;
}
