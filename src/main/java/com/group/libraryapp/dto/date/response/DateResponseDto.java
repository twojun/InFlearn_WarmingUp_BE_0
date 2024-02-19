package com.group.libraryapp.dto.date.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateResponseDto {

    private String dayOfTheWeek;

    public DateResponseDto(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}


