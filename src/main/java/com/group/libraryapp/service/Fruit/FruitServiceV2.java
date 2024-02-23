package com.group.libraryapp.service.Fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.request.FruitCreateRequestDto;
import com.group.libraryapp.dto.fruit.request.FruitSaleStateUpdateRequestDto;
import com.group.libraryapp.dto.fruit.response.FruitNoSalePriceResponseDto;
import com.group.libraryapp.dto.fruit.response.FruitNoSalePriceAndCountResponseDto;
import com.group.libraryapp.repository.fruit.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FruitServiceV2 {

    private final FruitRepository fruitRepository;

    @Transactional
    public void createFruit(FruitCreateRequestDto request) {
        fruitRepository.save(new Fruit(request.getName(), request.getPrice(), request.getWarehousingDate()));
    }

    @Transactional
    public void setSaleFruitCount(long id, FruitSaleStateUpdateRequestDto request) {
        Fruit findFruit = fruitRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 과일 정보입니다."));

        findFruit.setSalesStatus(request.isSalesStatus());
    }

    public long getSaleFruitCount(String name) {
        return fruitRepository.countByNameAndSalesStatusIsTrue(name);
    }

    public List<FruitNoSalePriceResponseDto> getNoSaleAmount(String option, long price) {
        if (option.equals("GTE")) {
            return fruitRepository.findByPriceGreaterThanEqualAndSalesStatusIsFalse(price).stream()
                    .map(FruitNoSalePriceResponseDto::new)
                    .collect(Collectors.toList());
        } else {
            return fruitRepository.findByPriceLessThanEqualAndSalesStatusIsFalse(price).stream()
                    .map(FruitNoSalePriceResponseDto::new)
                    .collect(Collectors.toList());
        }
    }

    public List<FruitNoSalePriceAndCountResponseDto> getNoSaleAmountAndCount(String option, long price) {
        if (option.equals("GTE")) {
            long resultSize = fruitRepository.countByPriceGreaterThanEqualAndSalesStatusIsFalse(price);
            return fruitRepository.findByPriceGreaterThanEqualAndSalesStatusIsFalse(price).stream()
                    .map(fruit -> new FruitNoSalePriceAndCountResponseDto(resultSize, fruit))
                    .collect(Collectors.toList());
        } else {
            long resultSize = fruitRepository.countByPriceLessThanEqualAndSalesStatusIsFalse(price);
            return fruitRepository.findByPriceLessThanEqualAndSalesStatusIsFalse(price).stream()
                    .map(fruit -> new FruitNoSalePriceAndCountResponseDto(resultSize, fruit))
                    .collect(Collectors.toList());
        }
    }

}
