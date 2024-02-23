package com.group.libraryapp.dto.fruit.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FruitCreateRequestDto {

    private String name;
    private Long price;
    private LocalDate warehousingDate;
}
