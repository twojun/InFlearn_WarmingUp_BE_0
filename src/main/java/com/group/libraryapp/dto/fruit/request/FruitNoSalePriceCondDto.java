package com.group.libraryapp.dto.fruit.request;

import com.group.libraryapp.domain.fruit.Fruit;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FruitNoSalePriceCondDto {

    private String name;
    private Long price;
    private LocalDateTime warehousingDate;
    private boolean salesStatus;

}
