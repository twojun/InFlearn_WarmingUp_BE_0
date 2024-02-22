package com.group.libraryapp.service.Fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequestDto;
import com.group.libraryapp.dto.fruit.request.FruitSaleStateUpdateRequestDto;
import com.group.libraryapp.dto.fruit.response.FruitSaleNoSaleTotalPriceDto;
import com.group.libraryapp.repository.fruit.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public void createFruit(FruitCreateRequestDto request) {
        fruitRepository.createFruit(request);
    }

    public List<FruitSaleNoSaleTotalPriceDto> getSaleAndNoSaleTotalPrice(String name) {
        return fruitRepository.getSaleAndNoSaleTotalPrice(name);
    }

    public void updateSaleState(FruitSaleStateUpdateRequestDto request) {
        if (fruitRepository.isFruitNotExist(request)) {
            throw new IllegalStateException("존재하지 않는 과일 정보입니다.");
        }
        fruitRepository.updateFruitSaleState(request);
    }

}
