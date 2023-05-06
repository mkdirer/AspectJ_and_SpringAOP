package org.example;

public class Main {
    public static void main(String[] args) {
        ExampleService exampleService = new ExampleService();
        try
        {
            exampleService.shortRunningMethod();
            exampleService.longRunningMethod();
            exampleService.anotherLongRunningMethod();
            System.out.println();
            exampleService.throwingMethod();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
        }
    }
}
