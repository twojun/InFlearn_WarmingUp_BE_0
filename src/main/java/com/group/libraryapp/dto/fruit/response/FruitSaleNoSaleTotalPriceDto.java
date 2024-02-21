package com.group.libraryapp.dto.fruit.response;

import lombok.Data;

@Data
public class FruitSaleNoSaleTotalPriceDto {

    private long salesAmount;
    private long noSalesAmount;

    public FruitSaleNoSaleTotalPriceDto(long salesAmount, long noSalesAmount) {
        this.salesAmount = salesAmount;
        this.noSalesAmount = noSalesAmount;
    }
}
