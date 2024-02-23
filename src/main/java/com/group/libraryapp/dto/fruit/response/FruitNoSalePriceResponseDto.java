package com.group.libraryapp.dto.fruit.response;

import com.group.libraryapp.domain.fruit.Fruit;

import java.time.LocalDateTime;

public class FruitNoSalePriceResponseDto {

    private String name;
    private long price;
    private LocalDateTime warehousingDate;
    private boolean salesStatus;


    public FruitNoSalePriceResponseDto(Fruit fruit) {
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousingDate();
        this.salesStatus = fruit.isSalesStatus();
    }
}
