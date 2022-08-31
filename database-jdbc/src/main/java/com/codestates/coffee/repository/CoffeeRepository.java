package com.codestates.coffee.repository;

import com.codestates.coffee.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    /**
     * 해당 애너테이션을 이용하여 개발자가 직접 쿼리문을 작성해서 질의할 수 있도록 할수 있다.
     * :coffeeId는 findByCoffee(Long coffeeId)의
     * coffeeId 변수 값이 채워지는 동적 쿼리 파라미터(named parameter)이다.
     */
    @Query("SELECT * FROM COFFEE WHERE COFFEE_ID = :coffeeId")
    Optional<Coffee> findByCoffee(Long coffeeId);
}
