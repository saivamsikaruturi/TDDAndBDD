package com.example.mvntesting11;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarBase {

    @Autowired
   CarController carController;

    @MockBean
   CarService carService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @BeforeEach
    public void setup() throws CarNotFoundException {
        RestAssuredMockMvc.standaloneSetup(carController);
        Mockito.when(carService.getCarDetails("Test"))
                .thenReturn(new Car( "Test"));
    }

}
