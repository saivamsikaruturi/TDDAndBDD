package com.example.mvntesting11.steps;

import com.example.mvntesting11.FizzBuzz;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {

    FizzBuzz f;
    String play;
    @Given("Test Play Game Buzz")
    public void testPlayGameBuzz() {
        f=new FizzBuzz();
    }

    @When("I play a number {int}")
    public void iPlayANumber(int arg0) {
         play = f.play(arg0);
    }

    @Then("The return value is {string}")
    public void theReturnValueIs(String arg0) {
        Assertions.assertEquals(play,arg0);
    }
}
