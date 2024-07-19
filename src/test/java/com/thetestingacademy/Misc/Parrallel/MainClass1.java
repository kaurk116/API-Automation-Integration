package com.thetestingacademy.Misc.Parrallel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainClass1 {
    @BeforeTest
    public void before_Method_MC1(){
        long id= Thread.currentThread().getId();
        System.out.println(id);
    }
    @Test
    public void Method_MC11(){
        long id= Thread.currentThread().getId();
        System.out.println(id);
    }
    @Test
    public void Method_MC111(){
        long id= Thread.currentThread().getId();
        System.out.println(id);
    }

}