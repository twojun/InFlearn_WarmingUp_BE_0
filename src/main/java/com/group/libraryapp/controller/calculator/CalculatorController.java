package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculateAddRequestDto;
import com.group.libraryapp.dto.calculator.request.CalculateMultiplyRequestDto;
import com.group.libraryapp.dto.calculator.request.CalculateTwoNumbersRequestDto;
import com.group.libraryapp.dto.calculator.response.CalculateAddResponseDto;
import com.group.libraryapp.dto.calculator.response.CalculateTwoNumbersResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculateTwoNumbersRequestDto request) {
        return request.getNum1() + request.getNum2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculateMultiplyRequestDto request) {
        return request.getNumber1() * request.getNumber2();
    }

    @GetMapping("/api/v1/calc")
    public CalculateTwoNumbersResponseDto calculateThreeNumbers(CalculateTwoNumbersRequestDto request) {
        return new CalculateTwoNumbersResponseDto((request.getNum1() + request.getNum2()),
                (request.getNum1() - request.getNum2()),
                (request.getNum1() * request.getNum2()));
    }

    @PostMapping("/api/v2/calc")
    public CalculateAddResponseDto calculateFiveNumbers(@RequestBody CalculateAddRequestDto request) {
        int sum = 0;

        for (Integer numbers : request.getNumbers()) {
            sum += numbers;
        }
        return new CalculateAddResponseDto(sum);
    }
}
