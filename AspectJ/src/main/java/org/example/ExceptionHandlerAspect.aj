package org.example;

public aspect ExceptionHandlerAspect
{
    private Integer exceptionCount = 0;
    pointcut exceptionHandlerPointcut(): handler(Exception);

    after() throwing(Exception e): target(t) && exceptionHandlerPointcut()
    {
        System.out.println("Hello World");
    }

    after() throwing(Exception e) : target(org.example.Aspects.ExampleService) && call(void org.example.Aspects.ExampleService.throwingMethod())
    {
        exceptionCount+=1;
        String err = "Aspect catched exception from: " + thisJoinPoint.toString() +
                 " \nTotal exception count: " + exceptionCount.toString();
        System.out.println(err);
    }
}
