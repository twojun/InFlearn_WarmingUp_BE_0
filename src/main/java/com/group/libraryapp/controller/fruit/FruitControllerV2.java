package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequestDto;
import com.group.libraryapp.dto.fruit.request.FruitSaleStateUpdateRequestDto;
import com.group.libraryapp.dto.fruit.response.FruitNoSalePriceAndCountResponseDto;
import com.group.libraryapp.dto.fruit.response.FruitNoSalePriceResponseDto;
import com.group.libraryapp.service.Fruit.FruitServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FruitControllerV2 {

    private final FruitServiceV2 fruitServiceV2;

    // 과일 생성
    @PostMapping("/api/v2/fruit")
    public void createFruit(@RequestBody FruitCreateRequestDto request) {
        fruitServiceV2.createFruit(request);
    }

    // 과일 판매여부 수정
    @PostMapping("/api/v2/fruit/status/{id}")
    public void setSaleFruitCount(@PathVariable("id") long id, @RequestBody FruitSaleStateUpdateRequestDto request) {
        fruitServiceV2.setSaleFruitCount(id, request);
    }

    // 판매되었던 과일 개수 출력하기
    @GetMapping("/api/v2/fruit/count")
    public long getSaleFruitCount(@RequestParam String name) {
        return fruitServiceV2.getSaleFruitCount(name);
    }

    // 판매되지 않은 특정 금액, 이하 과일 목록들
    @GetMapping("/api/v2/fruit/list")
    public List<FruitNoSalePriceResponseDto> getNoSaleAmount(@RequestParam String option, @RequestParam long price) {
        return fruitServiceV2.getNoSaleAmount(option, price);
    }

    // 판매되지 않은 특정 금액, 이하 과일 목록들, 결과 반환 개수까지
    @GetMapping("/api/v2/fruit/list/result")
    public List<FruitNoSalePriceAndCountResponseDto> getNoSaleAmountAndResultCount(@RequestParam String option, @RequestParam long price) {
        return fruitServiceV2.getNoSaleAmountAndCount(option, price);
    }
}
