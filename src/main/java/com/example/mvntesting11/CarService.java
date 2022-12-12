package com.example.mvntesting11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    @Autowired
    CarRepository carRepository;


public CarService(CarRepository carRepository){
    this.carRepository=carRepository;
}
    public Car getCarDetails(String name) throws CarNotFoundException {
        Car car =carRepository.findByName(name);
        System.out.println("car::"+car);
        if(car==null){
            throw new CarNotFoundException("details not found");
        }
        return car;
    }
}
