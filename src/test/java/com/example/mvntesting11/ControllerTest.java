package com.example.mvntesting11;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCarDetails() throws Exception{
      when(carService.getCarDetails(anyString())).thenReturn(new Car(1,"test"));
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/test").param("name","test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("test"));
    }


//    @Test
//   public void testCarDetails_NotFound() throws Exception {
//       given(carService.getCarDetails(anyString())).willThrow(CarNotFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/cars/test").param("name","test"))
//                .andExpect(status().isNotFound());
//    }


}
