package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    // select * from fruit where name = ? and salesStatus = true;
    long countByNameAndSalesStatusIsTrue(String name);

    // select * from fruit where price >= ? and salesStatus = false;
    List<Fruit> findByPriceGreaterThanEqualAndSalesStatusIsFalse(long price);
    long countByPriceGreaterThanEqualAndSalesStatusIsFalse(long price);

    // select * from fruit where price <= ? and salesStatus = false;
    List<Fruit> findByPriceLessThanEqualAndSalesStatusIsFalse(long price);
    long countByPriceLessThanEqualAndSalesStatusIsFalse(long price);

}
