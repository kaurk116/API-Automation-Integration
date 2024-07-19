package com.thetestingacademy.Misc.Parrallel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainClass2 {
    @BeforeTest
    public void before_Method_MC2(){
        long id= Thread.currentThread().getId();
        System.out.println(id);
    }
    @Test
    public void Method_MC22(){
        long id= Thread.currentThread().getId();
        System.out.println(id);
    }
    @Test
    public void Method_MC222(){
        long id= Thread.currentThread().getId();
        System.out.println(id);
    }
}

