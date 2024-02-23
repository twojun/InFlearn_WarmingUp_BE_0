package com.group.libraryapp.domain.fruit;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Fruit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private LocalDate warehousingDate;
    private boolean salesStatus = false;

    public Fruit() {}

    // 과일 생성
    public Fruit(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    // 판매 상태 변경
    public void setSalesStatus(boolean salesStatus) {
        this.salesStatus = salesStatus;
    }

}
