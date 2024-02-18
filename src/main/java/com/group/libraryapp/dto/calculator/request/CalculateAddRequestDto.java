package com.group.libraryapp.dto.calculator.request;

import lombok.Getter;

@Getter
public class CalculateAddRequestDto {

    private int number1;
    private int number2;
    private int number3;

    public CalculateAddRequestDto(int number1, int number2, int number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }
}
