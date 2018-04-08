package com.springboot1.controller;

import com.springboot1.domain.Car;
import com.springboot1.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SessionAttributes(types = {String.class}, names = {"car"})
@Controller
public class CarController {

    @Resource(name = "carService")
    private CarService carService;

    @RequestMapping("hithymeleaf")
    public String hiThymeleaf(@RequestParam(value = "name", required = false,
            defaultValue = "world") String name, Model model) {
        // 模型数据
        model.addAttribute("name", name);
        // 视图(resource下的模板中的html:hello.html)
        return "hello";
    }

    @GetMapping("carlist")
    public ModelAndView find() {
        List<Car> cars = carService.find();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("carlist");
        mv.addObject("cars", cars);

        Car car = new Car(5, "奔驰", 486d, new Date());
        mv.addObject("car", car);

        return mv;
    }
}
