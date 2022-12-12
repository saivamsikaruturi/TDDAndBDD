package com.example.mvntesting11;

public class FizzBuzz {
   public String play(int number){
     if(number==0) throw new IllegalArgumentException("Number is not valid");
     if(number%3==0) return "FIZZ";
     if(number%5==0) return "BUZZ";
     return String.valueOf(number);
    }
}
