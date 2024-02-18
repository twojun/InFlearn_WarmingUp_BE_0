package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculateAddRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculateAddRequestDto request) {
        return request.getNumber1() + request.getNumber2() + request.getNumber3();
    }
}
