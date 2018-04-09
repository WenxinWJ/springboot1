package com.springboot1;

import com.springboot1.domain.Car;
import com.springboot1.mapper.CarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarMapperTes {

    @Resource(name = "carMapper")
    private CarMapper carMapper;

    @Test
    public void testcar() {
        for (Car car : carMapper.find()) {
            System.out.println(car);
        }
    }

    @Test
    public void testfindId() {
        System.out.println(carMapper.findId(1));
    }

    @Test
    public void testaddCar() {

    }

    @Test
    public void testfindCar() {
        for (Car car : carMapper.findCar("", null, null)) {
            System.out.println(car);
        }
    }
}
