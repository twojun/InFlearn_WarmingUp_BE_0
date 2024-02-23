package com.group.libraryapp.dto.fruit.response;

import com.group.libraryapp.domain.fruit.Fruit;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FruitNoSalePriceAndCountResponseDto {

    private Long resultSize;

    private String name;
    private LocalDate warehousingDate;
    private boolean salesStatus;

    public FruitNoSalePriceAndCountResponseDto(Long resultSize, Fruit fruit) {
        this.resultSize = resultSize;
        this.name = fruit.getName();
        this.warehousingDate = fruit.getWarehousingDate();
        this.salesStatus = fruit.isSalesStatus();
    }
}
