package com.group.libraryapp.dto.calculator.response;

import lombok.Data;

@Data
public class CalculateTwoNumbersResponseDto {
    private int add;
    private int minus;
    private int multiply;

    public CalculateTwoNumbersResponseDto(int add, int minus, int multiply) {
        this.add = add;
        this.minus = minus;
        this.multiply = multiply;
    }
}



