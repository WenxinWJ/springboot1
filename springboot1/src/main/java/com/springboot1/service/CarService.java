package com.springboot1.service;

import com.springboot1.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarService {

    // 查询所有 以集合代替数据库
    public List<Car> find() {
        List<Car> list = new ArrayList<>();
        Car car = new Car(1, "福特", 500d, new Date());
        Car car1 = new Car(2, "玛莎拉蒂", 800d, new Date());

        list.add(car);
        list.add(car1);

        return list;
    }

}
