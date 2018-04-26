package com.springboot1.service;

import com.springboot1.domain.Car;
import com.springboot1.mapper.CarMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CarService {

    @Resource(name = "carMapper")
    private CarMapper carMapper;

    // 增
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer addCar(Car car) {
        return carMapper.addCar(car);
    }

    // 删
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer remove(Integer id) {
        return carMapper.remove(id);
    }

    // 改
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer modify(Car car) {
        return carMapper.modify(car);
    }

    // 查(全部)
    public List<Car> find() {
        return carMapper.find();
    }

    // 查(id)
    public Car findId(Integer id) {
        return carMapper.findId(id);
    }

    // 模糊查询
    public List<Car> findCar(String name, Date beginDate, Date endDate) {
        return carMapper.findCar(name, beginDate, endDate);
    }
}
