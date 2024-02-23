package com.group.libraryapp.service.Fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequestDto;
import com.group.libraryapp.dto.fruit.request.FruitIsExistDto;
import com.group.libraryapp.dto.fruit.request.FruitSaleStateUpdateRequestDto;
import com.group.libraryapp.dto.fruit.response.FruitSaleNoSaleTotalPriceDto;
import com.group.libraryapp.repository.fruit.FruitJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FruitServiceV1 {

    private final FruitJdbcRepository fruitJdbcRepository;

    public void createFruit(FruitCreateRequestDto request) {
        fruitJdbcRepository.createFruit(request);
    }

    public List<FruitSaleNoSaleTotalPriceDto> getSaleAndNoSaleTotalPrice(String name) {
        return fruitJdbcRepository.getSaleAndNoSaleTotalPrice(name);
    }

    public void updateSaleState(FruitIsExistDto request) {
        if (fruitJdbcRepository.isFruitNotExist(request)) {
            throw new IllegalStateException("존재하지 않는 과일 정보입니다.");
        }
        fruitJdbcRepository.updateFruitSaleState(request);
    }

}
