package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {


    //기본적으로 Food 타입으로 찾는데 중복이 있으면 qualifier 를 통해 해결
    @Autowired
    Food food;
    /**
     * DI 받을 이름으로 지정 가능
     */
    @Autowired
    Food chicken;

    @Qualifier("pizza")
    @Autowired
    Food pizza;

    // 우선순위는 세부적인거 먼저
    @Test
    void test() {
        food.eat();
        chicken.eat();
        pizza.eat();

    }
}
