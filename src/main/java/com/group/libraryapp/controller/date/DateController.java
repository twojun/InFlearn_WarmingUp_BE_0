package com.group.libraryapp.controller.date;

import com.group.libraryapp.dto.date.request.DateRequestDto;
import com.group.libraryapp.dto.date.response.DateResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class DateController {

    @GetMapping("/api/v1/day-of-the-week")
    public DateResponseDto getDayOfWeek(DateRequestDto request) {
        return new DateResponseDto(request.getDate()
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
                .toUpperCase());
    }
}
