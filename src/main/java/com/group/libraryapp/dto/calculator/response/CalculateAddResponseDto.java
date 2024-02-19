package com.group.libraryapp.dto.calculator.response;

import lombok.Data;

@Data
public class CalculateAddResponseDto {

    private Integer sum;

    public CalculateAddResponseDto(Integer sum) {
        this.sum = sum;
    }
}
