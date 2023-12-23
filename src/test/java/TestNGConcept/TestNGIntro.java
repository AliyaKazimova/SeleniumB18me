package TestNGConcept;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority = 1,invocationCount = 20) //going to be executed first and will run 20 times, first test case on terminal will be indexed 0 and will run till test1 (19)
    public void test1(){
        System.out.println("Test1");
        System.out.println("Creating data");
    }

    @Test(priority = 3)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 2)
    public void test3(){
        System.out.println("Test3");
    }

    //TO GO INSIDE OF METHOD COMMAND AND CLICK
    //TestNG runs in ascending order not insertion
    //We manage order with PRIORITY key word  f.e --> @Test(priority = 4)
    //To run 1 test case multiple time we use -invocationCount- key word  f.e --> @Test(priority = 1,invocationCount = 20)


    @Test(priority = 4)
    public void ahmet(){
        System.out.println("Test4");
    }


}
