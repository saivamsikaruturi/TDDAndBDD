Feature: Fizz Buzz

  Scenario: Play FizzBuzz
    Given Test Play Game Buzz
    When I play a number 6
    Then The return value is "FIZZ"

  Scenario: Play FizzBuzz
    Given Test Play Game Buzz
    When I play a number 5
    Then The return value is "BUZZ"







