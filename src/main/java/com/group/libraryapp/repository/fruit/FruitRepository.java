package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.request.FruitCreateRequestDto;
import com.group.libraryapp.dto.fruit.request.FruitSaleStateUpdateRequestDto;
import com.group.libraryapp.dto.fruit.response.FruitSaleNoSaleTotalPriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FruitRepository {

    private final JdbcTemplate jdbcTemplate;

    public void createFruit(FruitCreateRequestDto request) {
        String sql = "insert into fruit (name, warehousing_date, price) values (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public List<FruitSaleNoSaleTotalPriceDto> getSaleAndNoSaleTotalPrice(String name) {
        String sql = "select " +
                "(select sum(price) from fruit where is_sale = 1) as salesAmount, " +
                "(select sum(price) from fruit where is_sale = 0) as notSalesAmount";

//        String sql = "select is_sale, sum(price) as total_price from fruit group by is_sale";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long salesAmount = rs.getLong("salesAmount");
            long notSalesAmount = rs.getLong("notSalesAmount");
            return new FruitSaleNoSaleTotalPriceDto(salesAmount, notSalesAmount);
        });
    }

    public boolean isFruitNotExist(FruitSaleStateUpdateRequestDto request) {
        String selectSql = "select * from fruit where fruit_id = ?";
        return jdbcTemplate.query(selectSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
    }

    public void updateFruitSaleState(FruitSaleStateUpdateRequestDto request) {
        String sql = "update fruit set is_sale = 1 where fruit_id = ?";
        jdbcTemplate.update(sql, request.getId());
    }
}
