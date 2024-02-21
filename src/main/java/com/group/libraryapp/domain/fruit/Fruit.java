package com.group.libraryapp.domain.fruit;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Fruit {

    private String name;
    private LocalDateTime warehousingDate;
    private Long price;

    public Fruit(String name, LocalDateTime warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }
}
