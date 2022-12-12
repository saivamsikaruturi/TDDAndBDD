package com.example.mvntesting11;


import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @MockBean
    private CarRepository carRepository;


    @Mock
    private CarService carService;



    @Test
    public void getCars_returnsCars() throws CarNotFoundException {
        CarService carService = new CarService(carRepository);
        Car car = new Car("test");
       given(carRepository.findByName(anyString())).willReturn(car);
       Car carDetails = carService.getCarDetails("test");
        assertThat(carDetails.getId()).isEqualTo(0L);
        assertThat(carDetails.getName()).isEqualTo("test");
    }
}
