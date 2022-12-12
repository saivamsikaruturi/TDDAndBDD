package com.example.mvntesting11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void shouldAutoGenerateId()  {
        Car persistedCar = testEntityManager.persistFlushFind(new Car( "hybrid"));
        assertThat(persistedCar.getId()).isNotNull();
    }

    @Test
    public void findByName_returnCarDetails() throws Exception{
       Car test = testEntityManager.persistFlushFind(new Car( "test"));
        Car test1 = carRepository.findByName("test");
       assertThat(test1.getName()).isEqualTo(test.getName());
       assertThat(test1.getId()).isEqualTo(test.getId());

    }

}
