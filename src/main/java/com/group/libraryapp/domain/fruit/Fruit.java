package com.group.libraryapp.domain.fruit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Fruit {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Long price;
    private LocalDateTime warehousingDate;
    private boolean salesStatus = false;

    public Fruit() {}

    // 과일 생성
    public Fruit(String name, Long price, LocalDateTime warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    // 판매 상태 변경
    public void setSalesStatus(boolean salesStatus) {
        this.salesStatus = salesStatus;
    }

}
