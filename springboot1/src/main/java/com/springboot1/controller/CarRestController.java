package com.springboot1.controller;

import com.springboot1.domain.Car;
import com.springboot1.domain.CustomType;
import com.springboot1.service.CarService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8080", maxAge = 3600)
@RequestMapping("/api")
public class CarRestController {

    @Resource(name = "carService")
    private CarService carService;

    /**
     * 増
     *
     * @param car
     * @return
     */
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Car car) {
        CustomType customType = new CustomType(400, "错误");
        if (carService.addCar(car) > 0) {
            customType.setCode(200);
            customType.setMessage("成功");
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }

    /**
     * 删
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
        CustomType customType = new CustomType(400, "错误");
        if (carService.remove(id) > 0) {
            customType.setCode(200);
            customType.setMessage("成功");
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }

    /**
     * 改
     *
     * @param car
     * @return
     */
    @RequestMapping(value = "/cars", method = RequestMethod.PUT)
    public ResponseEntity<?> modify(@RequestBody Car car) {
        CustomType customType = new CustomType(400, "错误");
        if (carService.modify(car) > 0) {
            customType.setCode(200);
            customType.setMessage("成功");
        }
        return new ResponseEntity<>(customType, HttpStatus.OK);
    }

    /**
     * 查
     *
     * @return
     */
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ResponseEntity<?> find() {

        List<Car> cars = carService.find();
        if (cars.isEmpty()) {
            return new ResponseEntity<>(new CustomType(400, "错误"), HttpStatus.OK);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    /**
     * id 查
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findCarId(@PathVariable("id") Integer id) {
        Car car = carService.findId(id);
        if (car == null) {
            return new ResponseEntity<>(new CustomType(400, "查无此id"), HttpStatus.OK);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    //
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public ResponseEntity<?> findCar(@RequestParam(value = "name", required = false) String name,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "beginDate", required = false) Date beginDate,
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "endDate", required = false) Date endDate) {
        System.out.println(name + "   " + beginDate + "  " + endDate);
        List<Car> cars = carService.findCar(name, beginDate, endDate);
        if (cars.isEmpty()) {
            return new ResponseEntity<>(new CustomType(400, "错误"), HttpStatus.OK);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

}
