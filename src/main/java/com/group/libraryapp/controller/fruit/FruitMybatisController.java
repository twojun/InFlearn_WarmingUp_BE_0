package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequiredArgsConstructor
//public class FruitMybatisController {
//
//    private final FruitMapper fruitMapper;
//
//    @GetMapping("/test/mybatis")
//    public void mybatisTest() {
//        List<Fruit> findFruits = fruitMapper.findAll();
//        for (Fruit findFruit : findFruits) {
//            System.out.println(findFruit.getId());
//            System.out.println(findFruit.getName());
//            System.out.println(findFruit.getPrice());
//            System.out.println(findFruit.getWarehousingDate());
//        }
//    }
//}
