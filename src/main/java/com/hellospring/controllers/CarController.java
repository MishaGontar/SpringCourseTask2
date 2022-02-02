package com.hellospring.controllers;

import com.hellospring.persistence.dao.services.interfaces.CarService;
import com.hellospring.persistence.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping( "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/all")
    public ModelAndView getAllCar(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("cars", carService.findAll());
        modelAndView.setViewName("view/car/cars");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addCar(HttpServletRequest request) {
        Car car = new Car();
        car.setBrand(request.getParameter("brand"));
        car.setEngineCapacity(Float.parseFloat(request.getParameter("capacity")));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        car.setModel(request.getParameter("model"));
        car.setSpeedMax(Integer.parseInt(request.getParameter("speedMax")));
        carService.addCar(car);
        return "redirect: all";
    }

    @GetMapping(value = "/findByBrand")
    public ModelAndView findByBrand(@RequestParam("brand") String brand, ModelAndView modelAndView) {
        modelAndView.addObject("cars", carService.findAllByBrand(brand));
        modelAndView.setViewName("view/car/search");
        return modelAndView;
    }

    @GetMapping(value = "/findByBrandAndModelAndSpeedMax")
    public ModelAndView findByBrandAndModelAndSpeedMax(
            @RequestParam("brand") String brand,
            @RequestParam("model") String modelCar,
            @RequestParam("speedMax") int speed, ModelAndView model) {
        model.addObject("cars", carService.findAllByBrandAndModelAndSpeedMax(brand, modelCar,speed));
        model.setViewName("view/car/search");
        return model;
    }

    @GetMapping(value = "/removeById")
    public String removeById(@RequestParam("id") long id) throws InterruptedException {
        carService.removeById(id);
        return "redirect:all";
    }

    @GetMapping(value = "/removeAllByBrand")
    public String removeAllByBrand(@RequestParam("brand") String brand)throws InterruptedException {
        carService.removeAllByBrand(brand);
        return "redirect:all";
    }
}
