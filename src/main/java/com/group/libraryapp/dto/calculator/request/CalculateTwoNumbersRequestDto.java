package com.group.libraryapp.dto.calculator.request;

import lombok.Data;

@Data
public class CalculateTwoNumbersRequestDto {

    private int num1;
    private int num2;

    public CalculateTwoNumbersRequestDto(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
