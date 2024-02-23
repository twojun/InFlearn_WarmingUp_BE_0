package com.group.libraryapp;

import com.group.libraryapp.domain.fruit.Fruit;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitDbService initDbService;

    @PostConstruct
    public void init() {
        initDbService.initFruitDb();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitDbService {

        private final EntityManager em;
        public void initFruitDb() {
            Fruit fruit1 = createFruit("사과", 4000L, LocalDate.of(2024, 02, 01));
            Fruit fruit2 = createFruit("바나나", 2000L, LocalDate.of(2024, 02, 01));
            Fruit fruit3 = createFruit("사과", 6500L, LocalDate.of(2024, 02, 01));
            Fruit fruit4 = createFruit("사과", 7000L, LocalDate.of(2024, 02, 01));
            Fruit fruit5 = createFruit("사과", 3000L, LocalDate.of(2024, 02, 01));
            Fruit fruit6 = createFruit("포도", 12000L, LocalDate.of(2024, 02, 01));
            Fruit fruit7 = createFruit("사과", 2500, LocalDate.of(2024, 02, 01));
            Fruit fruit8 = createFruit("사과", 5000L, LocalDate.of(2024, 02, 01));

            em.persist(fruit1);
            em.persist(fruit2);
            em.persist(fruit3);
            em.persist(fruit4);
            em.persist(fruit5);
            em.persist(fruit6);
            em.persist(fruit7);
            em.persist(fruit8);

        }

        private static Fruit createFruit(String name, long price, LocalDate warehousingDate) {
            return new Fruit(name, price, warehousingDate);
        }
    }
}


