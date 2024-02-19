package com.group.libraryapp.dto.calculator.request;

import lombok.Getter;

@Getter
public class CalculateMultiplyRequestDto {

    private int number1;
    private int number2;

    public CalculateMultiplyRequestDto(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
}
