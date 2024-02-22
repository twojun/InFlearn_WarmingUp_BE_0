package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequestDto;
import com.group.libraryapp.dto.fruit.request.FruitSaleStateUpdateRequestDto;
import com.group.libraryapp.dto.fruit.response.FruitSaleNoSaleTotalPriceDto;
import com.group.libraryapp.service.Fruit.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FruitController {

    private final FruitService fruitService;

    @PostMapping("/api/v1/fruit")
    public void createFruit(@RequestBody FruitCreateRequestDto request) {
        fruitService.createFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public List<FruitSaleNoSaleTotalPriceDto> getSaleAndNoSaleTotalPrice(@RequestParam String name) {
        return fruitService.getSaleAndNoSaleTotalPrice(name);
    }

    @PutMapping("/api/v1/fruit")
    public void updateSaleState(@RequestBody FruitSaleStateUpdateRequestDto request) {
        fruitService.updateSaleState(request);
    }
}