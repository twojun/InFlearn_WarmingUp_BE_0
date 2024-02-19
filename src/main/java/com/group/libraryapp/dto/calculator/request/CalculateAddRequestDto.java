package com.group.libraryapp.dto.calculator.request;

import lombok.Data;

import java.util.List;

@Data
public class CalculateAddRequestDto {

    private List<Integer> numbers;

    public CalculateAddRequestDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public CalculateAddRequestDto() {
    }
}
