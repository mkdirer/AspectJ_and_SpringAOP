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
        }
        catch (Exception e)
        {
        }

        try
        {
            exampleService.throwingMethod();
        }
        catch (Exception e)
        {
        }
        try
        {
            exampleService.throwingMethod();
        }
        catch (Exception e)
        {
        }
    }
}
