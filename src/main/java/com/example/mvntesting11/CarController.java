package com.example.mvntesting11;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars/test")
    private Car getCar(@RequestParam String name) throws CarNotFoundException {
        return carService.getCarDetails(name);
    }


}
