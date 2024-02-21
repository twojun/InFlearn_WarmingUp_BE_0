package com.group.libraryapp.dto.fruit.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FruitCreateRequestDto {

    private String name;
    private LocalDate warehousingDate;
    private Long price;
}
